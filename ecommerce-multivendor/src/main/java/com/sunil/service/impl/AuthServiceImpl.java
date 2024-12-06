package com.sunil.service.impl;

import com.sunil.config.JwtProvider;
import com.sunil.domain.USER_ROLE;
import com.sunil.model.Cart;
import com.sunil.model.Seller;
import com.sunil.model.User;
import com.sunil.model.VerificationCode;
import com.sunil.repository.CartRepository;
import com.sunil.repository.SellerRepository;
import com.sunil.repository.UserRepository;
import com.sunil.repository.VerificationCodeRepository;
import com.sunil.request.LoginRequest;
import com.sunil.response.AuthResponse;
import com.sunil.response.SignUpRequest;
import com.sunil.service.AuthService;
import com.sunil.service.EmailService;
import com.sunil.util.OtpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final JwtProvider jwtProvider;

    private final VerificationCodeRepository verificationCodeRepository;

    private final EmailService emailService;

    private final CustomUserServiceImpl customUserService;

    private final SellerRepository sellerRepository;

    @Override
    public void sendLoginOtp(String email, USER_ROLE role) throws Exception {
        String SIGNING_PREFIX = "signing_";
        String SELLER_PREFIX = "seller_";

        if (email.startsWith(SIGNING_PREFIX)) {
            email = email.substring(SIGNING_PREFIX.length());
            if (role.equals(USER_ROLE.ROLE_SELLER)) {
                Seller seller = sellerRepository.findByEmail(email);
                if (seller == null)
                    throw new Exception("seller does not exist with email:- "+ email);
            } else {
                User user = userRepository.findByEmail(email);
                if (user == null) {
                    throw new Exception("user does not exist with this email");
                }
            }
        }
        VerificationCode isExists = verificationCodeRepository.findByEmail(email);
        if (isExists != null) {
           verificationCodeRepository.delete(isExists);
        }

        String otp = OtpUtil.generateOtp();

        VerificationCode  verificationCode = new VerificationCode();
        verificationCode.setOtp(otp);
        verificationCode.setEmail(email);
        verificationCodeRepository.save(verificationCode);

        String subject = "Linus Playlists merch login/signup otp";
        String text = "your login/singup otp is - ";

        emailService.sendVerificationOtpEmail(email, otp, subject, text);
    }

    @Override
    public String createUser(SignUpRequest req) throws Exception {

        VerificationCode verificationCode = verificationCodeRepository.findByEmail(req.getEmail());

        if (verificationCode == null || !verificationCode.getOtp().equals(req.getOtp()))
            throw new Exception("wrong otp...");

        User user = userRepository.findByEmail(req.getEmail());
        if (user == null) {
            User createdUser = new User();
            createdUser.setEmail(req.getEmail());
            createdUser.setFullName(req.getFullName());
            createdUser.setRole(USER_ROLE.ROLE_CUSTOMER);
            createdUser.setMobile("9393793719");
            createdUser.setPassword(passwordEncoder.encode(req.getOtp()));

            user = userRepository.save(createdUser);

            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }
        List<GrantedAuthority> authorities = new ArrayList();
        authorities.add(new SimpleGrantedAuthority(USER_ROLE.ROLE_CUSTOMER.toString()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(req.getEmail(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);
    }

    @Override
    public AuthResponse signing(LoginRequest req) {
        String username = req.getEmail();
        String otp = req.getOtp();

        Authentication authentication = authenticate(username, otp);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Login Success");

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String roleName = authorities.isEmpty() ? null : authorities.iterator().next().getAuthority();

        authResponse.setRole(USER_ROLE.valueOf(roleName));
        return authResponse;
    }

    private Authentication authenticate(String username, String otp) {

        UserDetails userDetails = customUserService.loadUserByUsername(username);

        VerificationCode verificationCode = verificationCodeRepository.findByEmail(username);

        if (userDetails == null || !verificationCode.getOtp().equals(otp))
            throw new BadCredentialsException("wrong otp");

        return new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );
    }
}

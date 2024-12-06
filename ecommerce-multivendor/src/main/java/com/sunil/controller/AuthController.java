package com.sunil.controller;

import com.sunil.domain.USER_ROLE;
import com.sunil.model.User;
import com.sunil.model.VerificationCode;
import com.sunil.repository.UserRepository;
import com.sunil.request.LoginRequest;
import com.sunil.response.APIResponse;
import com.sunil.response.AuthResponse;
import com.sunil.response.SignUpRequest;
import com.sunil.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignUpRequest req) throws Exception {

        String jwt = authService.createUser(req);
        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setMessage("register success");
        res.setRole(USER_ROLE.ROLE_CUSTOMER);

        return ResponseEntity.ok(res);
    }

//    @PostMapping("/send/login-signup-otp")
//    public ResponseEntity<APIResponse> sendOtpHandler(@RequestBody VerificationCode req) throws Exception {
//
//        authService.sendLoginOtp(req.getEmail());
//
//        APIResponse res = new APIResponse();
//        res.setResponse("otp sent successfully");
//
//        return ResponseEntity.ok(res);
//    }

    @PostMapping("/signIn")
    public ResponseEntity<AuthResponse> loginHandler(@RequestBody LoginRequest req) throws Exception {
        AuthResponse authResponse = authService.signing(req);
        return ResponseEntity.ok(authResponse);
    }
}

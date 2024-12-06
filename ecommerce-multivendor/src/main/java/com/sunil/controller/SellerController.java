package com.sunil.controller;

import com.sunil.model.Seller;
import com.sunil.model.VerificationCode;
import com.sunil.repository.VerificationCodeRepository;
import com.sunil.request.LoginOtpRequest;
import com.sunil.request.LoginRequest;
import com.sunil.response.APIResponse;
import com.sunil.response.AuthResponse;
import com.sunil.service.AuthService;
import com.sunil.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService sellerService;

    private final AuthService authService;

    private final VerificationCodeRepository verificationCodeRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginSeller(@RequestBody LoginRequest loginRequest) throws Exception {
        String otp = loginRequest.getOtp();
        String email = loginRequest.getEmail();

        VerificationCode verificationCodeDB = verificationCodeRepository.findByEmail(email);
        if (verificationCodeDB == null || !verificationCodeDB.getOtp().equals(loginRequest.getOtp()))
            throw new Exception("wrong otp");

        loginRequest.setEmail("seller_" + email);
        AuthResponse authResponse = authService.signing(loginRequest);

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/send/login-signup-otp")
    public ResponseEntity<APIResponse> sendOtpHandler(@RequestBody LoginOtpRequest req) throws Exception {
        authService.sendLoginOtp(req.getEmail(), req.getRole());
        APIResponse res = new APIResponse();
        res.setMessage("otp sent successfully");

        return ResponseEntity.ok(res);
    }

    @PatchMapping("/verify/otp")
    public ResponseEntity<Seller> verifySellerEmail(@PathVariable String otp) throws Exception {

    }
}

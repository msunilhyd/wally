package com.sunil.service;

import com.sunil.request.LoginRequest;
import com.sunil.response.AuthResponse;
import com.sunil.response.SignUpRequest;

public interface AuthService {

    void sendLoginOtp(String email) throws Exception;

    String createUser(SignUpRequest req) throws Exception;

    AuthResponse signing(LoginRequest req) throws Exception;
}

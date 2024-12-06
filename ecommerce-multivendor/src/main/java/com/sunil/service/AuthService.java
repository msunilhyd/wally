package com.sunil.service;

import com.sunil.domain.USER_ROLE;
import com.sunil.request.LoginRequest;
import com.sunil.response.AuthResponse;
import com.sunil.response.SignUpRequest;

public interface AuthService {

    void sendLoginOtp(String email, USER_ROLE role) throws Exception;

    String createUser(SignUpRequest req) throws Exception;

    AuthResponse signing(LoginRequest req) throws Exception;
}

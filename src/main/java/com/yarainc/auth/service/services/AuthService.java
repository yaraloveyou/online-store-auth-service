package com.yarainc.auth.service.services;

import com.yarainc.auth.service.domains.JwtRequest;
import com.yarainc.auth.service.domains.JwtResponse;
import jakarta.security.auth.message.AuthException;
import lombok.NonNull;

public interface AuthService {
    JwtResponse login(@NonNull JwtRequest authRequest) throws AuthException;
    JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException;
    JwtResponse refresh(@NonNull String refreshToken) throws AuthException;
}

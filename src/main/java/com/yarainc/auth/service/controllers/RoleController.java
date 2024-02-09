package com.yarainc.auth.service.controllers;

import com.yarainc.auth.service.domains.JwtAuthentication;
import com.yarainc.auth.service.services.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class RoleController {

    private final AuthServiceImpl authService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("user")
    public ResponseEntity<String> userPage() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("admin")
    public ResponseEntity<String> adminPage() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
    }
}

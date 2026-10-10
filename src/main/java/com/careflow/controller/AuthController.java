package com.careflow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careflow.dto.LoginRequest;
import com.careflow.dto.LoginResponse;
import com.careflow.dto.RegisterRequest;
import com.careflow.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService service;
    public AuthController(AuthService service) { this.service=service; }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequest r) {
        service.register(r); return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest r) { return service.login(r); }
}
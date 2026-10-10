package com.careflow.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.careflow.dto.LoginRequest;
import com.careflow.dto.LoginResponse;
import com.careflow.dto.RegisterRequest;
import com.careflow.entity.User;
import com.careflow.enums.Role;
import com.careflow.repository.UserRepository;
import com.careflow.security.JwtService;

@Service
public class AuthService {
    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthService(UserRepository users, PasswordEncoder encoder, JwtService jwt) {
        this.users=users; this.encoder=encoder; this.jwt=jwt;
    }

    public void register(RegisterRequest r) {
        if (users.findByEmail(r.email()).isPresent())
            throw new IllegalArgumentException("Email already registered");
        User u = new User();
        u.setName(r.name()); u.setEmail(r.email());
        u.setPassword(encoder.encode(r.password()));
        u.setRole(Role.PATIENT);
        users.save(u);
    }

    public LoginResponse login(LoginRequest r) {
        User u = users.findByEmail(r.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        if (!encoder.matches(r.password(), u.getPassword()))
            throw new IllegalArgumentException("Invalid credentials");
        return new LoginResponse(jwt.generateToken(u.getEmail(), u.getRole().name()),
                u.getRole().name(), u.getId(), u.getName());
    }
}
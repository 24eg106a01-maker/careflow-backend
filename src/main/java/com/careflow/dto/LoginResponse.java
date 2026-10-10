package com.careflow.dto;

public record LoginResponse(String token, String role, Long userId, String name) {}

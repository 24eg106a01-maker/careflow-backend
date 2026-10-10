package com.careflow.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.careflow.entity.User;
import com.careflow.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repository;
    public CustomUserDetailsService(UserRepository repository) { this.repository = repository; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return org.springframework.security.core.userdetails.User.withUsername(u.getEmail()).password(u.getPassword())
                .roles(u.getRole().name()).build();
    }
}
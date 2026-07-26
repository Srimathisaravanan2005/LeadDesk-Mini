package com.leaddesk.demo.service;

import com.leaddesk.demo.dto.LoginRequest;
import com.leaddesk.demo.model.Admin;
import com.leaddesk.demo.repository.AdminRepository;
import com.leaddesk.demo.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtService jwtService;

    public String login(LoginRequest request) {

        System.out.println("Login attempt: " + request.getEmail());

        Admin admin = adminRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        System.out.println("Admin found: " + admin.getEmail());

        if (!admin.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        System.out.println("Password matched");

        String token = jwtService.generateToken(admin.getEmail());

        System.out.println("Token generated");

        return token;
    }
}
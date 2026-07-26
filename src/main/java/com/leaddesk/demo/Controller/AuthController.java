package com.leaddesk.demo.Controller;

import com.leaddesk.demo.dto.LoginRequest;
import com.leaddesk.demo.dto.LoginResponse;
import com.leaddesk.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"https://leaddesk-frontenddh.vercel.app", "http://localhost:5173", "http://localhost:5174"})
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        String token = authenticationService.login(request);
        return new LoginResponse(token);
    }
}

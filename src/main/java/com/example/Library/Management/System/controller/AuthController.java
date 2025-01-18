package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.AuthRequest;
import com.example.Library.Management.System.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;




@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 🔑 Register New User
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AuthRequest authRequest) {
        String token = authService.register(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok(Map.of("message", "User registered successfully!", "token", token));
    }

    // 🔐 User Login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        String token = authService.authenticate(username, password);
        return ResponseEntity.ok(Map.of("message", "Login successful!", "token", token));
    }
}
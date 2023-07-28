package com.scorpions.auth;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    // Authentication APIs

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // Implement the logic to authenticate user based on employee id
        // Return JWT token upon successful login
        return ResponseEntity.ok("JWT Token");
    }

    @PutMapping("/auth/password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        // Implement password change functionality
        return ResponseEntity.ok("Password changed successfully");
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<String> logout() {
        // Implement logout functionality (invalidate token)
        return ResponseEntity.ok("Logged out successfully");
    }

}
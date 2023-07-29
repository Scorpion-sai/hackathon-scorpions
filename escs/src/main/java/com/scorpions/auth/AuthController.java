package com.scorpions.auth;

import com.scorpions.auth.req.LoginRequest;
import com.scorpions.auth.resp.LoginResponse;
import java.time.Duration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    // Authentication APIs

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        // Implement the logic to authenticate user based on employee id
        LoginResponse response = new LoginResponse();
        response.setAuthToken("JWT Token");
        response.setDuration(Duration.ofMinutes(30));
        // Return JWT token upon successful login
        return ResponseEntity.ok(response);
    }

    /*@PutMapping("/auth/password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        // Implement password change functionality
        return ResponseEntity.ok("Password changed successfully");
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<String> logout() {
        // Implement logout functionality (invalidate token)
        return ResponseEntity.ok("Logged out successfully");
    }
*/
}
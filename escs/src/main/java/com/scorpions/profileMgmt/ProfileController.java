package com.scorpions.profileMgmt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfileController {
    // Profile Management APIs

    @PostMapping("/profile")
    public ResponseEntity<String> addProfile(@RequestBody AddProfileRequest request) {
        // Implement adding/updating employee profile details
        return ResponseEntity.ok("Profile added/updated successfully");
    }

    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(@RequestBody UpdateProfileRequest request) {
        // Implement updating employee profile details
        return ResponseEntity.ok("Profile updated successfully");
    }

    @DeleteMapping("/profile/{employeeId}")
    public ResponseEntity<String> deleteProfile(@PathVariable String employeeId) {
        // Implement deleting employee profile by employeeId
        return ResponseEntity.ok("Profile deleted successfully");
    }

    @GetMapping("/profiles")
    public ResponseEntity<GetProfilesResponse> getProfiles() {
        // Implement getting all employee profiles
        GetProfilesResponse response = new GetProfilesResponse();
        // Populate response with profiles data
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{employeeId}")
    public ResponseEntity<GetProfileResponse> getProfile(@PathVariable String employeeId) {
        // Implement getting employee profile by employeeId
        GetProfileResponse response = new GetProfileResponse();
        // Populate response with profile data
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/project/{projectId}")
    public ResponseEntity<GetProfileByProjectIdResponse> getProfileByProjectId(@PathVariable String projectId) {
        // Implement getting employee profiles associated with a project by projectId
        GetProfileByProjectIdResponse response = new GetProfileByProjectIdResponse();
        // Populate response with profile data related to the project
        return ResponseEntity.ok(response);
    }

}
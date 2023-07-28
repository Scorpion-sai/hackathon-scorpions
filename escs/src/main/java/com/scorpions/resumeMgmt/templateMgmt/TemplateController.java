package com.scorpions.resumeMgmt.templateMgmt;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TemplateController {
    @GetMapping("/resume/templates")
    public ResponseEntity<GetResumeTemplatesResponse> getResumeTemplates() {
        // Implement getting available resume templates
        GetResumeTemplatesResponse response = new GetResumeTemplatesResponse();
        // Populate response with resume templates data
        return ResponseEntity.ok(response);
    }

    @PostMapping("/resume/templates")
    public ResponseEntity<String> addTemplate(@RequestBody AddResumeTemplateRequest request) {
        // Implement adding a new resume template
        return ResponseEntity.ok("Resume template added successfully");
    }

    @PutMapping("/resume/templates/{templateId}")
    public ResponseEntity<String> updateTemplate(@PathVariable String templateId,
            @RequestBody UpdateResumeTemplateRequest request) {
        // Implement updating an existing resume template by templateId
        return ResponseEntity.ok("Resume template updated successfully");
    }

    @DeleteMapping("/resume/templates/{templateId}")
    public ResponseEntity<String> deleteTemplate(@PathVariable String templateId) {
        // Implement deleting a resume template by templateId
        return ResponseEntity.ok("Resume template deleted successfully");
    }
}

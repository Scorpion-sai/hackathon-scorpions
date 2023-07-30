package com.scorpions.auth.resp;

import java.time.Duration;
import lombok.Data;

@Data
public class LoginResponse {
    private String authToken;
    private int expiryTimeInSecs;
    private String emailId;
    private Long userId;
}


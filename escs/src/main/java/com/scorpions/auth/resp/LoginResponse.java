package com.scorpions.auth.resp;

import java.time.Duration;
import lombok.Data;

@Data
public class LoginResponse {
    private String authToken;
    private Duration duration;
}


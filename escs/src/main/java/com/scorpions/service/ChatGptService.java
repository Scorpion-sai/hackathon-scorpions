package com.scorpions.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class ChatGptService {

    String endpoint = "https://api.openai.com/v1/chat/completions";
    String apiKey = "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";

    // Prompt user for input string
    String response = "empty";

    public String getChatGptResponse(String messagge) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enteres your message: " + messagge);

            // Send input to ChatGPT API and display response
            response = ChatBot.sendQuery(messagge, endpoint, apiKey);
        } catch (Exception e) {
        }
        response = response.trim().replaceAll(" ", "").replaceAll("\n", "").replaceAll("\\n", "");
        return response;
    }
}

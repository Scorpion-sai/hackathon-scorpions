package com.scorpions.chatgpt.chatbot;

import com.scorpions.service.ChatGptService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatBotController {

  private final ChatGptService chatGptService;

    // Chatbot Integration API

    @PostMapping("/chatbot")
    public ResponseEntity<ChatbotResponse> chatWithBot(@RequestBody String request) {
        // Implement the logic to process user input and get response from ChatGPT
        // Populate response with the chatbot's reply

        String chatGptResponse = chatGptService.getChatGptResponse(request);
        if(chatGptResponse.isEmpty()){
            System.out.println("\n\n Controller: \n+"+
            "chatGptResponse is empty");
        }
        System.out.println("Controller Respionse from ChatGpt");
        ChatbotResponse response = new ChatbotResponse();
        response.setResponse(chatGptResponse);
        return ResponseEntity.ok(response);
    }

}
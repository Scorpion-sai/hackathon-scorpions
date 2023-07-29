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
        String chatGptResponse = chatGptService.getChatGptResponse(request);
        ChatbotResponse response = new ChatbotResponse();
        response.setResponse(chatGptResponse);
        return ResponseEntity.ok(response);
    }

}
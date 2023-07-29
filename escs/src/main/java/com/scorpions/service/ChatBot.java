package com.scorpions.service;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ChatBot {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatBot.class);

    public static String sendQuery(String input, String endpoint, String apiKey) throws IOException {
        // Build input and API key params
        JsonObject payload = new JsonObject();
        JsonObject message = new JsonObject();
        JsonArray messageList = new JsonArray();

        // message.addProperty(endpoint, apiKey);
        message.addProperty("content", input);
        message.addProperty("role", "user");

        messageList.add(message);
    

        payload.addProperty("model", "gpt-3.5-turbo"); // model is important
        payload.add("messages", messageList);

        StringEntity inputEntity = new StringEntity(payload.toString(), ContentType.APPLICATION_JSON);

        // Build POST request
        HttpPost post = new HttpPost(endpoint);
        post.setEntity(inputEntity);
        post.setHeader("Authorization", "Bearer " + apiKey);
        post.setHeader("Content-Type", "application/json");

        // Send POST request and parse response
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post)) {
            System.out.println("PostRequest" + post);
            HttpEntity resEntity = response.getEntity();
            String resJsonString = new String(resEntity.getContent().readAllBytes(), StandardCharsets.UTF_8);
            JsonObject resJson = new JsonParser().parse(resJsonString).getAsJsonObject();

            // Parse JSON response
            JsonArray responseArray = resJson.getAsJsonArray("choices");
            List<String> responseList = new ArrayList<>();

            for (int i = 0; i < responseArray.size(); i++) {
                JsonObject responseObj = responseArray.get(i).getAsJsonObject();
                String responseString = responseObj.get("message").getAsJsonObject().get("content").getAsString();
                responseList.add(responseString);
            }
            return responseList.toString();
        } catch (IOException e) {
            LOGGER.error("Error sending request: {}", e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}

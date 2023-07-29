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
        message.addProperty("role", "system");

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
            System.out.println(" \nresJsonString: " + resJsonString);
            JsonObject resJson = new JsonParser().parse(resJsonString).getAsJsonObject();

            System.out.println(" \resJson: " + resJson);

            // Parse JSON response
            JsonArray responseArray = resJson.getAsJsonArray("choices");
            System.out.println("\n\n Choices: " + responseArray.get(0));
            List<String> responseList = new ArrayList<>();

            System.out.println("_-------------_-_-__----__---");
            for (int i = 0; i < responseArray.size(); i++) {
                JsonObject responseObj = responseArray.get(i).getAsJsonObject();
                System.out.println("resonseObk1: " + responseObj);
                String responseString = responseObj.get("message").getAsJsonObject().get("content").getAsString();
                System.out.println("responseString2 " + responseString);
                responseList.add(responseString);
            }
            if (responseList.isEmpty()) {
                System.out.println("EmptyRespionse");
            }
            responseList.forEach(messageR -> System.out.println("\n\t messageback:   " + messageR));

            // Convert response list to JSON and return it

            return responseList.toString();
        } catch (IOException e) {
            LOGGER.error("Error sending request: {}", e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}

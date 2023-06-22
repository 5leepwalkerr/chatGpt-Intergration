package com.chatintegration.chatgptintegration.controller;

import com.chatintegration.chatgptintegration.dto.ChatGptRequest;
import com.chatintegration.chatgptintegration.dto.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Value("${openai.api.model}")
    private String model;
    @Value("${openai.api.url}")
    private String apiUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping()
    public String chat(@RequestParam("prompt") String prompt){
        ChatGptRequest request = new ChatGptRequest(model,prompt);
        ChatGptResponse chatGptResponse = restTemplate.postForObject(apiUrl,request,ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }

    @PostMapping("/api")
    public String createRequest(@RequestBody ChatGptRequest request){
        ChatGptResponse chatGptResponse = restTemplate.postForObject(apiUrl,request,ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}

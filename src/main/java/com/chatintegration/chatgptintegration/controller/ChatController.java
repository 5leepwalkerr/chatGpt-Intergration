package com.chatintegration.chatgptintegration.controller;

import com.chatintegration.chatgptintegration.dto.ChatGptRequest;
import com.chatintegration.chatgptintegration.dto.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/api")
    public String chat(@RequestParam("prompt") String prompt){
        ChatGptRequest request = new ChatGptRequest(model,prompt);
        ChatGptResponse chatGptResponse = restTemplate.postForObject(apiUrl,request,ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }

}

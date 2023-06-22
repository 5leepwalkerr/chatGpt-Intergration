package com.chatintegration.chatgptintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ChatGptIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatGptIntegrationApplication.class, args);
    }

}

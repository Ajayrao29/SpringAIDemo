package org.example.springaionboardingservice.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiTestService {

    private final ChatClient chatClient;

    public AiTestService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String askAI(String question) {
        return chatClient
                .prompt(question)
                .call()
                .content();
    }
}
package org.example.springaionboardingservice.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OnboardingService {

    private final ChatClient chatClient;

    public OnboardingService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateOnboardingSummary(String clientName,
                                            String accountType,
                                            String country) {
        // Define template with {placeholders}
        String template = """
                You are a banking onboarding assistant.
                Generate a professional client onboarding summary for:
                
                - Client Name  : {clientName}
                - Account Type : {accountType}
                - Country      : {country}
                
                Include:
                1. Welcome message
                2. KYC documents required for {country}
                3. Account activation steps
                4. Compliance notes specific to {accountType}
                """;

        // Build PromptTemplate and inject variables
        PromptTemplate promptTemplate = new PromptTemplate(template);

        Prompt prompt = promptTemplate.create(Map.of(
                "clientName",   clientName,
                "accountType",  accountType,
                "country",      country
        ));

        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
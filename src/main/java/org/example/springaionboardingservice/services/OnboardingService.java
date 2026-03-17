package org.example.springaionboardingservice.services;

import org.example.springaionboardingservice.model.ClientProfile;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OnboardingService {

    private final ChatClient chatClient;

    public OnboardingService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String generateOnboardingSummary(ClientProfile profile) {
        // Task 2: Create PromptTemplate
        String userMessage = """
                You are a professional client onboarding specialist.
                Generate a professional onboarding summary for the following client:
                
                Client Name: {client_name}
                Industry: {industry}
                Services: {services}
                Region: {region}
                Tier: {tier}
                
                The summary should be welcoming, professional, and highlight how our services will benefit their specific industry and region.
                """;

        PromptTemplate template = new PromptTemplate(userMessage);

        // Task 3: Map Variables
        Map<String, Object> variables = Map.of(
                "client_name", profile.getClientName(),
                "industry", profile.getIndustry(),
                "services", profile.getServices(),
                "region", profile.getRegion(),
                "tier", profile.getTier()
        );

        // Task 4: Generate Prompt and Send using ChatClient
        Prompt prompt = template.create(variables);

        return chatClient.prompt(prompt)
                .call()
                .content();
    }
}
package org.example.springaionboardingservice.controller;

import org.example.springaionboardingservice.services.OnboardingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/onboarding")
public class OnboardingController {

    private final OnboardingService onboardingService;

    public OnboardingController(OnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    @GetMapping("/summary")
    public String getSummary(
            @RequestParam String clientName,
            @RequestParam String accountType,
            @RequestParam String country) {

        return onboardingService
                .generateOnboardingSummary(clientName, accountType, country);
    }
}
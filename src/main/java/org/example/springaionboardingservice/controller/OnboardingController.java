package org.example.springaionboardingservice.controller;

import org.example.springaionboardingservice.model.ClientProfile;
import org.example.springaionboardingservice.services.OnboardingService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/onboarding")
public class OnboardingController {

    private final OnboardingService onboardingService;

    public OnboardingController(OnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    @PostMapping("/summary")
    public String getSummary(@RequestBody ClientProfile profile) {
        return onboardingService.generateOnboardingSummary(profile);
    }
}
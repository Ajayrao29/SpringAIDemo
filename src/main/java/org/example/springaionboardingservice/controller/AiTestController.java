package org.example.springaionboardingservice.controller;

import org.example.springaionboardingservice.services.AiTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiTestController {

    private final AiTestService aiTestService;

    public AiTestController(AiTestService aiTestService) {
        this.aiTestService = aiTestService;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String q) {
        return aiTestService.askAI(q);
    }
}

package org.example.springaionboardingservice.model;

import lombok.Data;

@Data
public class ClientProfile {
    private String clientName;
    private String industry;
    private String services;
    private String region;
    private String tier;
}

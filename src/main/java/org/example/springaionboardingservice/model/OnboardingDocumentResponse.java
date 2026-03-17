package org.example.springaionboardingservice.model;

import java.util.List;

public class OnboardingDocumentResponse {
    private String summary;
    private List<String> next_steps;
    private List<String> risk_flags;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getNext_steps() {
        return next_steps;
    }

    public void setNext_steps(List<String> next_steps) {
        this.next_steps = next_steps;
    }

    public List<String> getRisk_flags() {
        return risk_flags;
    }

    public void setRisk_flags(List<String> risk_flags) {
        this.risk_flags = risk_flags;
    }
}


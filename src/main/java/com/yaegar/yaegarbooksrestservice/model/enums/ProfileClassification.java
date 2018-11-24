package com.yaegar.yaegarbooksrestservice.model.enums;

public enum ProfileClassification {
    PERSONAL("PERSONAL"), BUSINESS("BUSINESS");

    private final String profileClassification;

    ProfileClassification(String profileClassification) {
        this.profileClassification = profileClassification;
    }

    public String getProfileClassification() {
        return profileClassification;
    }
}

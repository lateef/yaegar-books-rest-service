package com.yaegar.yaegarbooksrestservice.util;

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

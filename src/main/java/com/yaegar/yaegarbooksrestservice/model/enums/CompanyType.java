package com.yaegar.yaegarbooksrestservice.model.enums;

public enum CompanyType {
    PRODUCTS("PRODUCTS"), SERVICES("SERVICES");

    private final String type;

    CompanyType(String type) {
        this.type = type;
    }
}

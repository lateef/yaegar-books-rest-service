package com.yaegar.yaegarbooksrestservice.util;

public enum CompanyType {
    PRODUCTS("PRODUCTS"), SERVICES("SERVICES");

    private final String type;

    CompanyType(String type) {
        this.type = type;
    }
}

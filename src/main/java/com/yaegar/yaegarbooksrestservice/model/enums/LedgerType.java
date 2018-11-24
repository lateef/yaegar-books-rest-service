package com.yaegar.yaegarbooksrestservice.model.enums;

public enum LedgerType {
    PRODUCT("PRODUCT"), DISCOUNT("DISCOUNT");

    private final String type;

    LedgerType(String type) {
        this.type = type;
    }
}

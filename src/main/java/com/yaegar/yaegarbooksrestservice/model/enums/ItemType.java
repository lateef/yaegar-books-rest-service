package com.yaegar.yaegarbooksrestservice.model.enums;

public enum ItemType {
    PRODUCT("PRODUCT"), SERVICE("SERVICE");

    private final String type;

    ItemType(String type) {
        this.type = type;
    }
}

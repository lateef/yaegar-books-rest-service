package com.yaegar.yaegarbooksrestservice.model.enums;

public enum TransactionSide {
    DEBIT("DEBIT"), CREDIT("CREDIT");

    private final String transactionSide;

    TransactionSide(String transactionSide) {
        this.transactionSide = transactionSide;
    }
}

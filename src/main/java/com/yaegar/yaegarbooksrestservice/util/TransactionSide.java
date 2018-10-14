package com.yaegar.yaegarbooksrestservice.util;

public enum TransactionSide {
    DEBIT("DEBIT"), CREDIT("CREDIT");

    private final String transactionSide;

    TransactionSide(String transactionSide) {
        this.transactionSide = transactionSide;
    }
}

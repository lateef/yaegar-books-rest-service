package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;
import com.yaegar.yaegarbooksrestservice.model.enums.TransactionSide;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Transaction")
public class Transaction extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1157309110453258864L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Long transactionId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "LedgerID", referencedColumnName = "LedgerID")
    private Ledger ledger;

    @NotEmpty
    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "TransactionID", referencedColumnName = "TransactionID")
    private Transaction transactionLink;

    @Column(name = "TransactionSide")
    @Enumerated(value = EnumType.STRING)
    private TransactionSide transactionSide;

    @Transient
    private String counterLedgerUuid;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Ledger getLedger() {
        return ledger;
    }

    public void setLedger(Ledger ledger) {
        this.ledger = ledger;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Transaction getTransactionLink() {
        return transactionLink;
    }

    public void setTransactionLink(Transaction transactionLink) {
        this.transactionLink = transactionLink;
    }

    public TransactionSide getTransactionSide() {
        return transactionSide;
    }

    public void setTransactionSide(TransactionSide transactionSide) {
        this.transactionSide = transactionSide;
    }

    public String getCounterLedgerUuid() {
        return counterLedgerUuid;
    }

    public void setCounterLedgerUuid(String counterLedgerUuid) {
        this.counterLedgerUuid = counterLedgerUuid;
    }
}

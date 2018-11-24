package com.yaegar.yaegarbooksrestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Ledger",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"ChartOfAccountsID", "Code"}),
                @UniqueConstraint(columnNames = {"ChartOfAccountsID", "Name", "ParentUuid"})
        }
)
public class Ledger extends AbstractLedger implements Serializable {
    private static final long serialVersionUID = 5289681276561008549L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LedgerID")
    private Long ledgerId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ChartOfAccountsID")
    private ChartOfAccounts chartOfAccounts;

    public Long getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(Long ledgerId) {
        this.ledgerId = ledgerId;
    }

    public ChartOfAccounts getChartOfAccounts() {
        return chartOfAccounts;
    }

    public void setChartOfAccounts(ChartOfAccounts chartOfAccounts) {
        this.chartOfAccounts = chartOfAccounts;
    }
}

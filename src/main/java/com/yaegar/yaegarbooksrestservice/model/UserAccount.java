package com.yaegar.yaegarbooksrestservice.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserAccount")
public class UserAccount extends Profile implements Serializable {

    private static final long serialVersionUID = 1669166674359001410L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserAccountID")
    private Long userAccountId;

    @Length(max = 32)
    @Column(name = "Name", nullable = false, length = 32)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ChartOfAccountsID")
    private ChartOfAccounts chartOfAccounts;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ChartOfAccounts getChartOfAccounts() {
        return chartOfAccounts;
    }

    @Override
    public void setChartOfAccounts(ChartOfAccounts chartOfAccounts) {
        this.chartOfAccounts = chartOfAccounts;
    }
}

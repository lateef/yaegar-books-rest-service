package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;
import com.yaegar.yaegarbooksrestservice.model.enums.ProfileClassification;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ChartOfAccounts")
public class ChartOfAccounts extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = -3532938641638388372L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChartOfAccountsID")
    private Long chartOfAccountsId;

    @Column(name = "ProfileClassification")
    @Enumerated(value = EnumType.STRING)
    private ProfileClassification profileClassification;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "UserAccountID", referencedColumnName = "UserAccountID")
    private UserAccount userAccount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CompanyID", referencedColumnName = "CompanyID")
    private Company company;

    @Transient
    private List<Ledger> ledgers;

    public Long getChartOfAccountsId() {
        return chartOfAccountsId;
    }

    public void setChartOfAccountsId(Long chartOfAccountsId) {
        this.chartOfAccountsId = chartOfAccountsId;
    }

    public ProfileClassification getProfileClassification() {
        return profileClassification;
    }

    public void setProfileClassification(ProfileClassification profileClassification) {
        this.profileClassification = profileClassification;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Ledger> getLedgers() {
        return ledgers;
    }

    public void setLedgers(List<Ledger> ledgers) {
        this.ledgers = ledgers;
    }
}

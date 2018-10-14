package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;
import com.yaegar.yaegarbooksrestservice.util.CompanyType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@MappedSuperclass
public abstract class Profile extends AbstractEntity {

    @Length(max = 32)
    @Column(name = "Name", nullable = false, length = 32)
    private String name;

    @Column(name = "CompanyType")
    @Enumerated(value = EnumType.STRING)
    private CompanyType companyType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ChartOfAccountsID")
    private ChartOfAccounts chartOfAccounts;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CountryID", referencedColumnName = "CountryID")
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public ChartOfAccounts getChartOfAccounts() {
        return chartOfAccounts;
    }

    public void setChartOfAccounts(ChartOfAccounts chartOfAccounts) {
        this.chartOfAccounts = chartOfAccounts;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

package com.yaegar.yaegarbooksrestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Company",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"Name", "CountryId"})})
public class Company extends Profile implements Serializable {
    private static final long serialVersionUID = 8810118317186831173L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompanyID")
    private Long companyId;

    @NotEmpty
    @Length(min = 36, max = 36)
    @Column(name = "Uuid", unique = true, nullable = false, length = 36)
    private String uuid;

    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "CompanyOwners",
            joinColumns = @JoinColumn(name = "companyID"),
            inverseJoinColumns = @JoinColumn(name = "userID")
    )
    private Set<User> owners = new HashSet<>();

    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "CompanyEmployees",
            joinColumns = @JoinColumn(name = "companyID"),
            inverseJoinColumns = @JoinColumn(name = "userID")
    )
    private Set<User> employees = new HashSet<>();

    @Length(max = 32)
    @Column(name = "Name", nullable = false, length = 32)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ChartOfAccountsID")
    private ChartOfAccounts chartOfAccounts;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Set<User> getOwners() {
        return owners;
    }

    public void setOwners(Set<User> owners) {
        this.owners = owners;
    }

    public Set<User> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<User> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChartOfAccounts getChartOfAccounts() {
        return chartOfAccounts;
    }

    public void setChartOfAccounts(ChartOfAccounts chartOfAccounts) {
        this.chartOfAccounts = chartOfAccounts;
    }
}

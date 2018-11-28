package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Customer",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"Name", "CompanyID"})})
public class Customer  extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 9108589308270906156L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Long customerId;

    @Length(max = 256)
    @Column(name = "Name", nullable = false, length = 256)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CompanyID", referencedColumnName = "CompanyID")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CompanyCustomerID", referencedColumnName = "CompanyID")
    private Company companyCustomer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "UserCustomerID", referencedColumnName = "CompanyID")
    private Company userCustomer;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompanyCustomer() {
        return companyCustomer;
    }

    public void setCompanyCustomer(Company companyCustomer) {
        this.companyCustomer = companyCustomer;
    }

    public Company getUserCustomer() {
        return userCustomer;
    }

    public void setUserCustomer(Company userCustomer) {
        this.userCustomer = userCustomer;
    }
}

package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Supplier",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"Name", "CompanyID"})})
public class Supplier  extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 7891126089265140570L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierID")
    private Long supplierId;

    @Length(max = 256)
    @Column(name = "Name", nullable = false, length = 256)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CompanyID", referencedColumnName = "CompanyID")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "CompanySupplierID", referencedColumnName = "CompanyID")
    private Company companySupplier;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "UserSupplierID", referencedColumnName = "CompanyID")
    private Company userSupplier;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public Company getCompanySupplier() {
        return companySupplier;
    }

    public void setCompanySupplier(Company companySupplier) {
        this.companySupplier = companySupplier;
    }

    public Company getUserSupplier() {
        return userSupplier;
    }

    public void setUserSupplier(Company userSupplier) {
        this.userSupplier = userSupplier;
    }
}

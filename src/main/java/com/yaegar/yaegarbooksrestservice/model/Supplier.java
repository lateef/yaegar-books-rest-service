package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Supplier",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"Name", "SuppliedToCompanyID"})})
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
    @JoinColumn(name = "SuppliedToCompanyID", referencedColumnName = "CompanyID")
    private Company suppliedToCompany;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SuppliedFromCompanyID", referencedColumnName = "CompanyID")
    private Company suppliedFromCompany;

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

    public Company getSuppliedToCompany() {
        return suppliedToCompany;
    }

    public void setSuppliedToCompany(Company suppliedToCompany) {
        this.suppliedToCompany = suppliedToCompany;
    }

    public Company getSuppliedFromCompany() {
        return suppliedFromCompany;
    }

    public void setSuppliedFromCompany(Company suppliedFromCompany) {
        this.suppliedFromCompany = suppliedFromCompany;
    }
}

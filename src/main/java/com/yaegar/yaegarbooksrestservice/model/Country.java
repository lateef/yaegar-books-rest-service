package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Country")
public class Country extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = -1518853741929542222L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountryID")
    private Long countryId;

    @Length(max = 32)
    @Column(name = "Name", nullable = false, unique = true, length = 32)
    private String name;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

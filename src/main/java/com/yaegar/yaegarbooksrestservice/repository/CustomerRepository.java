package com.yaegar.yaegarbooksrestservice.repository;

import com.yaegar.yaegarbooksrestservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUuid(String uuid);

    List<Customer> findByCompanyUuid(String companyUuid);
}
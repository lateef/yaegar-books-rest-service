package com.yaegar.yaegarbooksrestservice.repository;

import com.yaegar.yaegarbooksrestservice.model.Company;
import com.yaegar.yaegarbooksrestservice.model.Ledger;
import com.yaegar.yaegarbooksrestservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    Optional<Product> findByUuid(String uuid);

    Optional<Product> findByNameAndSupplierSuppliedToCompany(String name, Company suppliedToCompany);

        List<Product> findByLedgersIn(List<Ledger> ledgers);

}
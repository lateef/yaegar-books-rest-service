package com.yaegar.yaegarbooksrestservice.repository;

import com.yaegar.yaegarbooksrestservice.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository  extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByUuid(String uuid);

    List<Supplier> findByCompanyUuid(String companyUuid);
}
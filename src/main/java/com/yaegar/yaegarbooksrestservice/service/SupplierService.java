package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.Supplier;
import com.yaegar.yaegarbooksrestservice.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierService.class);

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Optional<Supplier> findByUuid(String uuid) {
        return supplierRepository.findByUuid(uuid);
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getSuppliersBySuppliedToCompanyCompanyUuid(String companyUuid) {
        return supplierRepository.findBySuppliedToCompanyUuid(companyUuid);
    }
}

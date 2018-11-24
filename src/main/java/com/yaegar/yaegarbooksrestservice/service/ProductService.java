package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.*;
import com.yaegar.yaegarbooksrestservice.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product, Supplier supplier, List<Ledger> ledgers, User user) {
        product.setSupplier(supplier);
        product.setLedgers(ledgers);

        if (supplier == null) {
            findByUuid(product.getUuid())
                    .ifPresent(e -> {
                        throw new IllegalStateException("Exception:: Product already exists");
                    });
        } else {
            findByNameAndSupplierSuppliedToCompany(product.getName(), supplier.getSuppliedToCompany())
                    .ifPresent(e -> {
                        throw new IllegalStateException("Exception:: Product already exists");
                    });
        }
        product.setCreatedBy(user);
        product.setUpdatedBy(user);
        return productRepository.save(product);
    }

    public Optional<Product> findByUuid(String uuid) {
        return productRepository.findByUuid(uuid);
    }

    public Optional<Product> findByNameAndSupplierSuppliedToCompany(String name, Company suppliedToCompany) {
        return productRepository.findByNameAndSupplierSuppliedToCompany(name, suppliedToCompany);
    }

    public List<Product> findByLedgersIn(List<Ledger> ledgers) {
        return productRepository.findByLedgersIn(ledgers);
    }
}

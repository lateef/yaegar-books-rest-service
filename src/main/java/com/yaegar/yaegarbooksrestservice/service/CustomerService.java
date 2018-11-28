package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.Customer;
import com.yaegar.yaegarbooksrestservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findByUuid(String uuid) {
        return customerRepository.findByUuid(uuid);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomersByCompanyUuid(String companyUuid) {
        return customerRepository.findByCompanyUuid(companyUuid);
    }
}

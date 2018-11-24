package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.Company;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Optional<Company> findByUuid(String uuid){
        return companyRepository.findByUuid(uuid);
    }

    public List<Company> getCompaniesByEmployeesIn(List<User> employees) {
        return companyRepository.findByEmployeesIn(employees);
    }
}

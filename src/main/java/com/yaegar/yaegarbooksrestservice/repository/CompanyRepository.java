package com.yaegar.yaegarbooksrestservice.repository;

import com.yaegar.yaegarbooksrestservice.model.Company;
import com.yaegar.yaegarbooksrestservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByUuid(String uuid);
    List<Company> findByEmployeesIn(List<User> employees);
}

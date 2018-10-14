package com.yaegar.yaegarbooksrestservice.repository;

import com.yaegar.yaegarbooksrestservice.model.ChartOfAccounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartOfAccountsRepository  extends JpaRepository<ChartOfAccounts, Long> {
}

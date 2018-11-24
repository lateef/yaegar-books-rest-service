package com.yaegar.yaegarbooksrestservice.repository;

import com.yaegar.yaegarbooksrestservice.model.ChartOfAccounts;
import com.yaegar.yaegarbooksrestservice.model.Ledger;
import com.yaegar.yaegarbooksrestservice.model.enums.LedgerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LedgerRepository extends JpaRepository<Ledger, Long> {
    Optional<Ledger> findByUuid(String uuid);
    List<Ledger> findByParentUuid(String parentUuid);
    List<Ledger> findByParentUuidAndLedgerType(String parentUuid, LedgerType ledgerType);
    List<Ledger> findByChartOfAccounts(ChartOfAccounts chartOfAccounts);
}

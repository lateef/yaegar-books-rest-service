package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.ChartOfAccounts;
import com.yaegar.yaegarbooksrestservice.model.Ledger;
import com.yaegar.yaegarbooksrestservice.model.LedgerTemplate;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.repository.LedgerRepository;
import com.yaegar.yaegarbooksrestservice.repository.LedgerTemplateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LedgerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LedgerService.class);

    private LedgerRepository ledgerRepository;
    private LedgerTemplateRepository ledgerTemplateRepository;

    public LedgerService(LedgerRepository ledgerRepository, LedgerTemplateRepository ledgerTemplateRepository) {
        this.ledgerRepository = ledgerRepository;
        this.ledgerTemplateRepository = ledgerTemplateRepository;
    }

    public List<Ledger> addAllToCompany(ChartOfAccounts chartOfAccounts, User createdBy) {
        List<LedgerTemplate> ledgerTemplates = ledgerTemplateRepository
                .findAll();
        final List<Ledger> ledgers = ledgerTemplates
                .stream()
                .map(ledgerTemplate -> {
                    final Ledger ledger = new Ledger();
                    ledger.setUuid(UUID.randomUUID().toString());
                    ledger.setName(ledgerTemplate.getName());
                    ledger.setDescription(ledgerTemplate.getDescription());
                    ledger.setChartOfAccounts(chartOfAccounts);
                    ledger.setParentUuid(ledgerTemplate.getParentUuid());
                    ledger.setCode(ledgerTemplate.getCode());
                    ledger.setCreatedBy(createdBy);
                    ledger.setUpdatedBy(createdBy);
                    ledger.setReportSortOrder(ledgerTemplate.getReportSortOrder());
                    ledger.setShowOnDashboard(ledgerTemplate.isShowOnDashboard());
                    return ledger;
                })
                .collect(Collectors.toList());
        return ledgerRepository.saveAll(ledgers);
    }

    public Optional<Ledger> findByUuid(String uuid) {
        return ledgerRepository.findByUuid(uuid);
    }

    public List<Ledger> findByParentUuid(String parentUuid) {
        return ledgerRepository.findByParentUuid(parentUuid);
    }

    public Ledger addLedger(Ledger ledger) {
        return ledgerRepository.save(ledger);
    }
}
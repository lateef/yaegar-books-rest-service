package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.*;
import com.yaegar.yaegarbooksrestservice.model.enums.LedgerType;
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
        final List<Ledger> existingLedgers = ledgerRepository.findByChartOfAccounts(chartOfAccounts);
        if (!existingLedgers.isEmpty()) {
            return existingLedgers;
        }
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
                    ledger.setCode(ledgerTemplate.getCode());
                    ledger.setLedgerType(ledgerTemplate.getLedgerType());
                    ledger.setCreatedBy(createdBy);
                    ledger.setUpdatedBy(createdBy);
                    ledger.setReportSortOrder(ledgerTemplate.getReportSortOrder());
                    ledger.setShowOnDashboard(ledgerTemplate.isShowOnDashboard());
                    return ledger;
                })
                .collect(Collectors.toList());
        final List<Ledger> ledgers1 = ledgers
                .stream()
                .map(ledger -> {
                    final LedgerTemplate matchingLedgerTemplate = ledgerTemplates
                            .stream()
                            .filter(ledgerTemplate -> ledgerTemplate.getName()
                                    .equals(ledger.getName()))
                            .findFirst()
                            .orElseThrow(NullPointerException::new);

                    if (matchingLedgerTemplate.getParentUuid() != null) {
                        final LedgerTemplate parentLedgerTemplate = ledgerTemplates
                                .stream()
                                .filter(ledgerTemplate -> ledgerTemplate.getUuid()
                                        .equals(matchingLedgerTemplate.getParentUuid()))
                                .findFirst()
                                .orElseThrow(NullPointerException::new);
                        final Ledger parentLedger = ledgers
                                .stream()
                                .filter(ledger1 -> ledger1.getName()
                                        .equals(parentLedgerTemplate.getName()))
                                .findFirst()
                                .orElseThrow(NullPointerException::new);
                        ledger.setParentUuid(parentLedger.getUuid());
                    }
                    return ledger;
                })
                .collect(Collectors.toList());
        return ledgerRepository.saveAll(ledgers1);
    }

    public Optional<Ledger> findByUuid(String uuid) {
        return ledgerRepository.findByUuid(uuid);
    }

    public List<Ledger> findByParentUuid(String parentUuid) {
        return ledgerRepository.findByParentUuid(parentUuid);
    }

    public List<Ledger> findByParentUuidAndLedgerType(String parentUuid, LedgerType ledgerType) {
        return ledgerRepository.findByParentUuidAndLedgerType(parentUuid, ledgerType);
    }

    public List<Ledger> findByChartOfAccounts(ChartOfAccounts chartOfAccounts) {
        return ledgerRepository.findByChartOfAccounts(chartOfAccounts);
    }

    public Ledger addLedger(Ledger ledger, User user) {
        Ledger parentLedger = findByUuid(ledger.getParentUuid())
                .orElseThrow(NullPointerException::new);
        return saveLedger(ledger.getName(), ledger.getUuid(), parentLedger, ledger.getLedgerType(), user);
    }

    public Ledger addLedger(String ledgerName, Ledger parentLedger, LedgerType ledgerType, User user) {
        return saveLedger(ledgerName, UUID.randomUUID().toString(), parentLedger, ledgerType, user);
    }

    private Ledger saveLedger(String ledgerName, String uuid, Ledger parentLedger, LedgerType ledgerType, User createdBy) {
        Ledger ledger1 = new Ledger();
        ledger1.setUuid(uuid);
        ledger1.setParentUuid(parentLedger.getUuid());
        ledger1.setName(ledgerName);
        ledger1.setLedgerType(ledgerType);
        ledger1.setDescription(ledgerName);
        ledger1.setCreatedBy(createdBy);
        ledger1.setUpdatedBy(createdBy);
        ledger1.setChartOfAccounts(parentLedger.getChartOfAccounts());
        ledger1.setReportSortOrder(parentLedger.getReportSortOrder());
        ledger1.setShowOnDashboard(parentLedger.isShowOnDashboard());

        final Integer maxCode = findByParentUuid(parentLedger.getUuid())
                .stream()
                .map(AbstractLedger::getCode)
                .max(Integer::compareTo)
                .orElse(parentLedger.getCode());
        ledger1.setCode(maxCode + 1);
        return ledgerRepository.save(ledger1);
    }
}

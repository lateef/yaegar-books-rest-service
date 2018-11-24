package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.ChartOfAccounts;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.repository.ChartOfAccountsRepository;
import com.yaegar.yaegarbooksrestservice.model.enums.ProfileClassification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChartOfAccountsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChartOfAccountsService.class);

    private ChartOfAccountsRepository chartOfAccountsRepository;

    public ChartOfAccountsService(ChartOfAccountsRepository chartOfAccountsRepository) {
        this.chartOfAccountsRepository = chartOfAccountsRepository;
    }

    public ChartOfAccounts createChartOfAccounts(ProfileClassification profileClassification, User user) {
        ChartOfAccounts chartOfAccounts = new ChartOfAccounts();
        chartOfAccounts.setUuid(UUID.randomUUID().toString());
        chartOfAccounts.setProfileClassification(profileClassification);
        chartOfAccounts.setCreatedBy(user);
        chartOfAccounts.setUpdatedBy(user);
        return chartOfAccountsRepository.save(chartOfAccounts);
    }
}

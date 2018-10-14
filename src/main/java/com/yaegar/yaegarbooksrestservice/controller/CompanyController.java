package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.ChartOfAccounts;
import com.yaegar.yaegarbooksrestservice.model.Company;
import com.yaegar.yaegarbooksrestservice.model.Ledger;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.service.ChartOfAccountsService;
import com.yaegar.yaegarbooksrestservice.service.CompanyService;
import com.yaegar.yaegarbooksrestservice.service.LedgerService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.yaegar.yaegarbooksrestservice.util.ProfileClassification.BUSINESS;

@RestController
public class CompanyController {
    private CompanyService companyService;
    private ChartOfAccountsService chartOfAccountsService;
    private LedgerService ledgerService;

    public CompanyController(
            CompanyService companyService,
            ChartOfAccountsService chartOfAccountsService,
            LedgerService ledgerService
    ) {
        this.companyService = companyService;
        this.chartOfAccountsService = chartOfAccountsService;
        this.ledgerService = ledgerService;
    }

    @RequestMapping(value = "/add-company", method = RequestMethod.POST)
    public ResponseEntity<Company> registerCompany(@RequestBody final Company company, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        Company company1 = null;
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            company.setCreatedBy(user);
            company.setUpdatedBy(user);
            company.setOwners(Collections.singleton(user));
            company.setEmployees(Collections.singleton(user));
            company1 = setupCompany(company, user);
        }
        return ResponseEntity.ok().headers(headers).body(company1);
    }

    @RequestMapping(value = "/get-companies", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getCompanies(ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        List<Company> companies = new ArrayList<>();
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            companies = companyService.getCompaniesByEmployeesIn(Collections.singletonList(user));
        }
        return ResponseEntity.ok().headers(headers).body(companies);
    }

    @Transactional
    Company setupCompany(@RequestBody Company company, User user) {
        final ChartOfAccounts chartOfAccounts = chartOfAccountsService.createChartOfAccounts(BUSINESS);
        company.setChartOfAccounts(chartOfAccounts);
        Company company1 = companyService.addCompany(company);
        List<Ledger> ledgers = ledgerService.addAllToCompany(chartOfAccounts, user);
        company1.getChartOfAccounts().setLedgers(ledgers);
        return company1;
    }
}

package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.Company;
import com.yaegar.yaegarbooksrestservice.model.Customer;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.service.CompanyService;
import com.yaegar.yaegarbooksrestservice.service.CustomerService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private CompanyService companyService;
    private CustomerService customerService;

    public CustomerController(CompanyService companyService, CustomerService customerService) {
        this.companyService = companyService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/add-customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> addCustomer(@RequestBody final Customer customer, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        Customer customer1 = null;
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            Company company = companyService.findByUuid(customer.getCompany().getUuid())
                    .orElseThrow(NullPointerException::new);
            customer.setCompany(company);
            if (customer.getCompanyCustomer() != null) {
                Company companyCustomer = companyService.findByUuid(customer.getCompanyCustomer().getUuid())
                        .orElse(null);
                customer.setCompanyCustomer(companyCustomer);
            }
            customer.setCreatedBy(user);
            customer.setUpdatedBy(user);
            customer1 = customerService.addCustomer(customer);
        }
        return ResponseEntity.ok().headers(headers).body(customer1);
    }

    @RequestMapping(value = "/get-customers/{companyUuid}", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers(@PathVariable String companyUuid, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            List<Customer> customers = customerService.getCustomersByCompanyUuid(companyUuid);
            return ResponseEntity.ok().headers(headers).body(customers);
        }
        return ResponseEntity.ok().headers(headers).body(new ArrayList<>());
    }
}

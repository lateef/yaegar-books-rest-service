package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.Company;
import com.yaegar.yaegarbooksrestservice.model.Supplier;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.service.CompanyService;
import com.yaegar.yaegarbooksrestservice.service.SupplierService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SupplierController {
    private CompanyService companyService;
    private SupplierService supplierService;

    public SupplierController(CompanyService companyService, SupplierService supplierService) {
        this.companyService = companyService;
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/add-supplier", method = RequestMethod.POST)
    public ResponseEntity<Supplier> addLedger(@RequestBody final Supplier supplier, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        Supplier supplier1 = null;
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            Company suppliedToCompany = companyService.findByUuid(supplier.getSuppliedToCompany().getUuid())
                    .orElseThrow(NullPointerException::new);
            supplier.setSuppliedToCompany(suppliedToCompany);
            if (supplier.getSuppliedFromCompany() != null) {
                Company suppliedFromCompany = companyService.findByUuid(supplier.getSuppliedFromCompany().getUuid())
                        .orElse(null);
                supplier.setSuppliedFromCompany(suppliedFromCompany);
            }
            supplier.setCreatedBy(user);
            supplier.setUpdatedBy(user);
            supplier1 = supplierService.addSupplier(supplier);
        }
        return ResponseEntity.ok().headers(headers).body(supplier1);
    }

    @RequestMapping(value = "/get-suppliers/{companyUuid}", method = RequestMethod.GET)
    public ResponseEntity<List<Supplier>> getSuppliers(@PathVariable String companyUuid, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            List<Supplier> suppliers = supplierService.getSuppliersBySuppliedToCompanyCompanyUuid(companyUuid);
            return ResponseEntity.ok().headers(headers).body(suppliers);
        }
        return ResponseEntity.ok().headers(headers).body(new ArrayList<>());
    }
}

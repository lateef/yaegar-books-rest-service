package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.*;
import com.yaegar.yaegarbooksrestservice.service.CompanyService;
import com.yaegar.yaegarbooksrestservice.service.LedgerService;
import com.yaegar.yaegarbooksrestservice.service.ProductService;
import com.yaegar.yaegarbooksrestservice.service.SupplierService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.yaegar.yaegarbooksrestservice.model.enums.LedgerType.DISCOUNT;
import static com.yaegar.yaegarbooksrestservice.model.enums.LedgerType.PRODUCT;

@RestController
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private CompanyService companyService;
    private LedgerService ledgerService;
    private ProductService productService;
    private SupplierService supplierService;

    public ProductController(
            CompanyService companyService,
            LedgerService ledgerService,
            ProductService productService,
            SupplierService supplierService
    ) {
        this.companyService = companyService;
        this.ledgerService = ledgerService;
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody final Product product, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;

        Product product1 = null;

        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            Company company = companyService.findByUuid(product.getSupplier().getCompany().getUuid())
                    .orElseThrow(NullPointerException::new);

            Supplier supplier = product.getSupplier();
            if (Objects.nonNull(supplier)) {
                supplier = supplierService.findByUuid(supplier.getUuid())
                        .orElse(null);
            }

            final List<Ledger> companyLedgers = ledgerService.findByChartOfAccounts(company.getChartOfAccounts());

            final Ledger salesIncome = companyLedgers
                    .stream()
                    .filter(ledger -> ledger.getName().equals("Sales Income"))
                    .findFirst()
                    .orElseThrow(NullPointerException::new);

            final Ledger purchases = companyLedgers
                    .stream()
                    .filter(ledger -> ledger.getName().equals("Purchases"))
                    .findFirst()
                    .orElseThrow(NullPointerException::new);

            final Ledger salesDiscount = companyLedgers
                    .stream()
                    .filter(ledger -> ledger.getName().equals("Sales Discount"))
                    .findFirst()
                    .orElseThrow(NullPointerException::new);

            final Ledger purchasesDiscount = companyLedgers
                    .stream()
                    .filter(ledger -> ledger.getName().equals("Purchases Discount"))
                    .findFirst()
                    .orElseThrow(NullPointerException::new);

            final Ledger incomeRevenueProductLedger = ledgerService.addLedger(product.getName(), salesIncome, PRODUCT, user);
            final Ledger costOfSalesGoodsProductLedger = ledgerService.addLedger(product.getName(), purchases, PRODUCT, user);
            final Ledger incomeRevenueProductDiscountLedger = ledgerService.addLedger(product.getName(), salesDiscount, DISCOUNT, user);
            final Ledger costOfSalesGoodsProductDiscountLedger = ledgerService.addLedger(product.getName(), purchasesDiscount, DISCOUNT, user);

            final List<Ledger> productLedgers = Arrays.asList(incomeRevenueProductLedger, costOfSalesGoodsProductLedger, incomeRevenueProductDiscountLedger, costOfSalesGoodsProductDiscountLedger);
            product1 = productService.addProduct(product, supplier, productLedgers, user);
        }
        return ResponseEntity.ok().headers(headers).body(product1);
    }

    @RequestMapping(value = "/get-products/{parentUuid}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts(@PathVariable String parentUuid, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            List<Ledger> productLedgers = ledgerService.findByParentUuidAndLedgerType(parentUuid, PRODUCT);
            List<Product> products = productService.findByLedgersIn(productLedgers);
            return ResponseEntity.ok().headers(headers).body(products);
        }
        return ResponseEntity.ok().headers(headers).body(new ArrayList<>());
    }
}

package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.*;
import com.yaegar.yaegarbooksrestservice.service.ProductService;
import com.yaegar.yaegarbooksrestservice.service.PurchaseOrderService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PurchaseOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseOrderController.class);
    private ProductService productService;
    private PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(ProductService productService, PurchaseOrderService purchaseOrderService) {
        this.productService = productService;
        this.purchaseOrderService = purchaseOrderService;
    }

    @RequestMapping(value = "/add-purchase-order", method = RequestMethod.POST)
    public ResponseEntity<PurchaseOrder> addPurchaseOrder(@RequestBody final PurchaseOrder purchaseOrder, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;

        PurchaseOrder purchaseOrder1 = null;

        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            final Product product = productService
                    .findByUuid(purchaseOrder
                                    .getLineItems()
                                    .get(0)
                                    .getProduct()
                                    .getUuid())
                    .orElseThrow(NullPointerException::new);
            purchaseOrder.getLineItems().forEach(lineItem -> lineItem.setProduct(product));
            purchaseOrder1 = purchaseOrderService.addPurchaseOrder(purchaseOrder, user);
//            Company suppliedToCompany = companyService.findByUuid(product.getSupplier().getSuppliedToCompany().getUuid())
//                    .orElseThrow(NullPointerException::new);
//
//            Supplier supplier = product.getSupplier();
//            if (Objects.nonNull(supplier)) {
//                supplier = supplierService.findByUuid(supplier.getUuid())
//                        .orElse(null);
//            }
//
//            final List<Ledger> companyLedgers = ledgerService.findByChartOfAccounts(suppliedToCompany.getChartOfAccounts());
//
//            final Ledger salesIncome = companyLedgers
//                    .stream()
//                    .filter(ledger -> ledger.getName().equals("Sales Income"))
//                    .findFirst()
//                    .orElseThrow(NullPointerException::new);
//
//            final Ledger purchases = companyLedgers
//                    .stream()
//                    .filter(ledger -> ledger.getName().equals("Purchases"))
//                    .findFirst()
//                    .orElseThrow(NullPointerException::new);
//
//            final Ledger salesDiscount = companyLedgers
//                    .stream()
//                    .filter(ledger -> ledger.getName().equals("Sales Discount"))
//                    .findFirst()
//                    .orElseThrow(NullPointerException::new);
//
//            final Ledger purchasesDiscount = companyLedgers
//                    .stream()
//                    .filter(ledger -> ledger.getName().equals("Purchases Discount"))
//                    .findFirst()
//                    .orElseThrow(NullPointerException::new);
//
//            final Ledger incomeRevenueProductLedger = ledgerService.addLedger(product.getName(), salesIncome, PRODUCT, user);
//            final Ledger costOfSalesGoodsProductLedger = ledgerService.addLedger(product.getName(), purchases, PRODUCT, user);
//            final Ledger incomeRevenueProductDiscountLedger = ledgerService.addLedger(product.getName(), salesDiscount, DISCOUNT, user);
//            final Ledger costOfSalesGoodsProductDiscountLedger = ledgerService.addLedger(product.getName(), purchasesDiscount, DISCOUNT, user);
//
//            final List<Ledger> productLedgers = Arrays.asList(incomeRevenueProductLedger, costOfSalesGoodsProductLedger, incomeRevenueProductDiscountLedger, costOfSalesGoodsProductDiscountLedger);
//            product1 = productService.addProduct(product, supplier, productLedgers, user);
        }
        return ResponseEntity.ok().headers(headers).body(purchaseOrder1);
    }

//    @RequestMapping(value = "/get-products/{parentUuid}", method = RequestMethod.GET)
//    public ResponseEntity<List<Product>> getProducts(@PathVariable String parentUuid, ModelMap model, HttpServletRequest httpServletRequest) {
//        final User user = (User) model.get("user");
//        HttpHeaders headers = null;
//        if (user != null) {
//            headers = AuthenticationUtils.getAuthenticatedUser(user);
//            List<Ledger> productLedgers = ledgerService.findByParentUuidAndLedgerType(parentUuid, PRODUCT);
//            List<Product> products = productService.findByLedgersIn(productLedgers);
//            return ResponseEntity.ok().headers(headers).body(products);
//        }
//        return ResponseEntity.ok().headers(headers).body(new ArrayList<>());
//    }
}

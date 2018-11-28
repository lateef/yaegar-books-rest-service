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
        }
        return ResponseEntity.ok().headers(headers).body(purchaseOrder1);
    }
}

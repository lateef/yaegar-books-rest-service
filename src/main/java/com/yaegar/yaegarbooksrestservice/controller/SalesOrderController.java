package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.Product;
import com.yaegar.yaegarbooksrestservice.model.SalesOrder;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.service.ProductService;
import com.yaegar.yaegarbooksrestservice.service.SalesOrderService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SalesOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesOrderController.class);
    private ProductService productService;
    private SalesOrderService salesOrderService;

    public SalesOrderController(ProductService productService, SalesOrderService salesOrderService) {
        this.productService = productService;
        this.salesOrderService = salesOrderService;
    }

    @RequestMapping(value = "/add-sales-order", method = RequestMethod.POST)
    public ResponseEntity<SalesOrder> addSalesOrder(@RequestBody final SalesOrder salesOrder, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;

        SalesOrder salesOrder1 = null;

        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            final Product product = productService
                    .findByUuid(salesOrder
                                    .getLineItems()
                                    .get(0)
                                    .getProduct()
                                    .getUuid())
                    .orElseThrow(NullPointerException::new);
            salesOrder.getLineItems().forEach(lineItem -> lineItem.setProduct(product));
            salesOrder1 = salesOrderService.addSalesOrder(salesOrder, user);
        }
        return ResponseEntity.ok().headers(headers).body(salesOrder1);
    }
}

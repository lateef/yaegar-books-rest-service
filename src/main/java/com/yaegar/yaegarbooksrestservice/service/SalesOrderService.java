package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.SalesOrder;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderService {

    private SalesOrderRepository salesOrderRepository;

    public SalesOrderService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    public SalesOrder addSalesOrder(SalesOrder salesOrder, User createdBy) {
        salesOrder.getLineItems().forEach(lineItem -> {
            lineItem.setCreatedBy(createdBy);
            lineItem.setUpdatedBy(createdBy);
        });
        salesOrder.setCreatedBy(createdBy);
        salesOrder.setUpdatedBy(createdBy);
        return salesOrderRepository.save(salesOrder);
    }
}

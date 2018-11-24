package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.PurchaseOrder;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {

    private PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder, User createdBy) {
        purchaseOrder.getLineItems().forEach(lineItem -> {
            lineItem.setCreatedBy(createdBy);
            lineItem.setUpdatedBy(createdBy);
        });
        purchaseOrder.setCreatedBy(createdBy);
        purchaseOrder.setUpdatedBy(createdBy);
        return purchaseOrderRepository.save(purchaseOrder);
    }
}

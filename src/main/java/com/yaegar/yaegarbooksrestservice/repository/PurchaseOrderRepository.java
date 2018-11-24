package com.yaegar.yaegarbooksrestservice.repository;

import com.yaegar.yaegarbooksrestservice.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository  extends JpaRepository<PurchaseOrder, Long> {
}

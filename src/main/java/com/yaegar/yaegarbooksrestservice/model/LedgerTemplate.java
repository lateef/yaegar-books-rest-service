package com.yaegar.yaegarbooksrestservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LedgerTemplate")
public class LedgerTemplate extends AbstractLedger  implements Serializable {
    private static final long serialVersionUID = -8913459909489996158L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LedgerTemplateID")
    private Long ledgerTemplateId;

    public Long getLedgerTemplateId() {
        return ledgerTemplateId;
    }

    public void setLedgerTemplateId(Long ledgerTemplateId) {
        this.ledgerTemplateId = ledgerTemplateId;
    }
}

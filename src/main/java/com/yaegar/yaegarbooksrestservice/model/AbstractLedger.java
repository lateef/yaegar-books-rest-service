package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public abstract class AbstractLedger extends AbstractEntity {
    @NotEmpty
    @Length(min = 36, max = 36)
    @Column(name = "Uuid", unique = true, nullable = false, length = 36)
    private String uuid;

    @Column(name = "Code", nullable = false)
    private int code;

    @NotEmpty
    @Column(name = "Name", nullable = false)
    private String name;

    @Length(min = 36, max = 36)
    @Column(name = "ParentUuid", length = 36)
    private String parentUuid;

    @Column(name = "Description")
    private String description;

    @Column(name = "ReportSortOrder", nullable = false)
    private int reportSortOrder;

    @Column(name = "ShowOnDashboard", nullable = false)
    private boolean showOnDashboard;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReportSortOrder() {
        return reportSortOrder;
    }

    public void setReportSortOrder(int reportSortOrder) {
        this.reportSortOrder = reportSortOrder;
    }

    public boolean isShowOnDashboard() {
        return showOnDashboard;
    }

    public void setShowOnDashboard(boolean showOnDashboard) {
        this.showOnDashboard = showOnDashboard;
    }
}

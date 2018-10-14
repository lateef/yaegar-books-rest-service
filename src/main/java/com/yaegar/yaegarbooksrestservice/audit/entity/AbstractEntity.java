package com.yaegar.yaegarbooksrestservice.audit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yaegar.yaegarbooksrestservice.model.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdBy", "updatedBy", "createdDateTime", "updatedDateTime"}
)
public abstract class AbstractEntity {

    @CreatedBy
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "CreatedByUserID", referencedColumnName = "UserID")
    private User createdBy;

    @LastModifiedBy
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "UpdatedByUserID", referencedColumnName = "UserID")
    private User updatedBy;

    @CreatedDate
    @Column(name = "CreationDateTime")
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(name = "UpdatedDateTime")
    private LocalDateTime updatedDateTime;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}

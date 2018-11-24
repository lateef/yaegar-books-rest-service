package com.yaegar.yaegarbooksrestservice.model;

import com.yaegar.yaegarbooksrestservice.audit.entity.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserConfirmation")
public class UserConfirmation extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = -6805296311886034780L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserConfirmationID")
    private Long userConfirmationId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "PhoneNumber", referencedColumnName = "PhoneNumber")
    private User user;

    @Column(name = "Code", length = 5, nullable = false)
    private String code;

    @Column(name = "Confirmed")
    private boolean confirmed;

    public Long getUserConfirmationId() {
        return userConfirmationId;
    }

    public void setUserConfirmationId(Long userConfirmationId) {
        this.userConfirmationId = userConfirmationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}

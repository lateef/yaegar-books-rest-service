package com.yaegar.yaegarbooksrestservice.repository;

import com.yaegar.yaegarbooksrestservice.model.UserConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserConfirmationRepository extends JpaRepository<UserConfirmation, Long> {
    Optional<UserConfirmation> findByUserPhoneNumber(String phoneNumber);
}

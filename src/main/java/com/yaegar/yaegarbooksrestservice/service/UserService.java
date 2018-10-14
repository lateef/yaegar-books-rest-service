package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.Role;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.model.UserConfirmation;
import com.yaegar.yaegarbooksrestservice.repository.RoleRepository;
import com.yaegar.yaegarbooksrestservice.repository.UserConfirmationRepository;
import com.yaegar.yaegarbooksrestservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserConfirmationRepository userConfirmationRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            UserConfirmationRepository userConfirmationRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userConfirmationRepository = userConfirmationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(final User user, UserConfirmation userConfirmation) {
        user.setAcceptedTerms(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roleSet = new HashSet<>();
        Optional<Role> role = roleRepository.findByAuthority(Role.AUTHORITY_USER);
        role.ifPresent(r -> {
            roleSet.add(r);
            user.setRoles(roleSet);
        });

        User savedUser = null;
        try {
            savedUser = userRepository.save(user);

            userConfirmation.setUuid(UUID.randomUUID().toString());
            userConfirmation.setUser(savedUser);
            userConfirmation.setCreatedDateTime(LocalDateTime.now());
            userConfirmation.setCode(String.format("%05d", new Random().nextInt(100000)));
            userConfirmationRepository.save(userConfirmation);

            savedUser.eraseCredentials();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return savedUser;
    }

    public UserConfirmation confirmUser(UserConfirmation userConfirmation) {
        Optional<UserConfirmation> optionalUserConfirmation = userConfirmationRepository
                .findByUserPhoneNumber(userConfirmation.getUser().getPhoneNumber());

        if (optionalUserConfirmation.isPresent()
                && optionalUserConfirmation.get().getCode().equals(userConfirmation.getCode())) {
            userConfirmation = optionalUserConfirmation.get();
            User user = userConfirmation.getUser();
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setFailedLoginAttempts(0);
            userConfirmation.setUpdatedDateTime(LocalDateTime.now());
            userConfirmation.setConfirmed(true);
            userConfirmation = userConfirmationRepository.save(userConfirmation);
            userConfirmation.getUser().eraseCredentials();
        }

        return userConfirmation;
    }

    public Optional<User> getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findOptionalByPhoneNumber(phoneNumber);
    }
}

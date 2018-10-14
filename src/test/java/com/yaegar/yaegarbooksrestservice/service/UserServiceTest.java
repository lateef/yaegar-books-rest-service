package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.model.Phone;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.model.UserConfirmation;
import com.yaegar.yaegarbooksrestservice.repository.RoleRepository;
import com.yaegar.yaegarbooksrestservice.repository.UserConfirmationRepository;
import com.yaegar.yaegarbooksrestservice.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserConfirmationRepository userConfirmationRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserService sut;

    @Before
    public void setup() {
        sut = new UserService(userRepository, roleRepository, userConfirmationRepository, passwordEncoder);
    }

    @Test
    public void shouldRegisterNewUser() {
        //arrange
        final String phoneNumber = "+447780708394";
        final String code = "44";

        final User expectedUser = new User();
        expectedUser.setUserId(1L);
        expectedUser.setPassword("Qq1111");
        expectedUser.setPhoneNumber(phoneNumber);

        final Phone expectedPhone = new Phone();
        expectedPhone.setPhoneId(1L);
        expectedPhone.setNumber(phoneNumber);
        expectedPhone.setCode(code);

        expectedUser.setPhones(Collections.singleton(expectedPhone));

        final User user = new User();
        user.setPassword("Qq1111");
        user.setPhoneNumber(phoneNumber);

        final UserConfirmation userConfirmation = new UserConfirmation();

        final UserConfirmation expectedUserConfirmation = new UserConfirmation();
        expectedUserConfirmation.setUser(user);
        expectedUserConfirmation.setCode("01200");

        when(userConfirmationRepository.save(userConfirmation)).thenReturn(expectedUserConfirmation);
        when(userRepository.save(user)).thenReturn(expectedUser);

        //act
        User actualUser = sut.register(user, userConfirmation);

        //assert
        verify(userRepository, times(1)).save(user);
        assertNotNull(actualUser.getUserId());
        assertEquals(actualUser.getPhones().size(), 1);
        assertTrue(actualUser.getPhones().contains(expectedPhone));
        verify(userConfirmationRepository, times(1)).save(userConfirmation);
    }

    @Test
    public void shouldConfirmUser() {
        //arrange
        final String phoneNumber = "+447780708394";
        final String code = "12345";
        UserConfirmation userConfirmation = new UserConfirmation();
        User user = new User();
        user.setPhoneNumber(phoneNumber);

        userConfirmation.setUuid(UUID.randomUUID().toString());
        userConfirmation.setUser(user);
        userConfirmation.setCreatedDateTime(LocalDateTime.now());
        userConfirmation.setCode(code);

        when(userConfirmationRepository.findByUserPhoneNumber(phoneNumber))
                .thenReturn(Optional.of(userConfirmation));
        when(userConfirmationRepository.save(userConfirmation)).thenReturn(userConfirmation);

        //act
        UserConfirmation actualUserConfirmation = sut.confirmUser(userConfirmation);

        //assert
        verify(userConfirmationRepository, times(1)).findByUserPhoneNumber(phoneNumber);
        assertTrue(actualUserConfirmation.isConfirmed());
    }

    @Test
    public void shouldLogin() {
        //TODO
    }
}

package com.yaegar.yaegarbooksrestservice.service;

import com.yaegar.yaegarbooksrestservice.repository.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {
    @Mock
    private CompanyRepository profileRepository;

    private CompanyService sut;

    @Before
    public void setup() {
        sut = new CompanyService(profileRepository);
    }

    @Test
    public void shouldAddNewProfile() {

    }
}

package org.example.integration.service;

import org.example.ApplicationRunner;
import org.example.database.entity.Company;
import org.example.database.repository.CrudRepository;
import org.example.dto.CompanyReadDto;
import org.example.listner.entity.EntityEvent;
import org.example.service.CompanyService;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = ApplicationRunner.class, initializers = ConfigDataApplicationContextInitializer.class)
class CompanyServiceIT {

    @Test
    void findById() {

    }

//    private static final Integer COMPANY_ID = 1;
//
//    @Mock
//    private CrudRepository<Integer, Company> companyRepository;
//    @Mock
//    private UserService userService;
//    @Mock
//    private ApplicationEventPublisher eventPublisher;
//    @InjectMocks
//    private CompanyService companyService;
//
//    @Test
//    void findById() {
//        doReturn(Optional.of(new Company(COMPANY_ID)))
//                .when(companyRepository).findById(COMPANY_ID);
//
//        var actualResult = companyService.findById(COMPANY_ID);
//
//        assertTrue(actualResult.isPresent());
//
//        var expectedResult = new CompanyReadDto(COMPANY_ID);
//        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
//
//        verify(eventPublisher).publishEvent(any(EntityEvent.class));
//        verifyNoMoreInteractions(eventPublisher, userService);
//    }
}
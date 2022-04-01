package com.ceiba.company.service;

import com.ceiba.company.model.entity.Company;
import com.ceiba.company.port.repository.CompanyRepository;
import com.ceiba.company.service.testdatabuilder.CompanyTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class TestCreateCompanyService  {

    @InjectMocks
    private CreateCompanyService createCompanyService;
    @Mock
    private CompanyRepository companyRepository;


    @Test
    @DisplayName("It should successfully create company")
    void shouldCreateSuccefullCompany() {

        Company company = new CompanyTestDataBuilder().build();
        Mockito.when(companyRepository.crear(company)).thenReturn(1);

        int companyId = createCompanyService.ejecutar(company);

        assertEquals(1, companyId);
        Mockito.verify(companyRepository, Mockito.times(1)).crear(company);

    }
}

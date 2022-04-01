package com.ceiba.company.service;

import com.ceiba.company.model.entity.Company;
import com.ceiba.company.port.repository.CompanyRepository;
import com.ceiba.company.service.testdatabuilder.CompanyTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCreateCompanyService  {

    @Test
    @DisplayName("It should successfully create company")
    void shouldCreateSuccefullCompany() {

        Company company = new CompanyTestDataBuilder().build();
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        Mockito.when(companyRepository.crear(company)).thenReturn(1);

        CreateCompanyService createCompanyService = new CreateCompanyService(companyRepository);

        int companyId = createCompanyService.ejecutar(company);

        assertEquals(1, companyId);
        Mockito.verify(companyRepository, Mockito.times(1)).crear(company);

    }
}

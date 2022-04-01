package com.ceiba.company.service;

import com.ceiba.BasePrueba;
import com.ceiba.company.model.entity.Company;
import com.ceiba.company.port.repository.CompanyRepository;
import com.ceiba.company.service.testdatabuilder.CompanyTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestUpdateCompanyService {

    @Test
    @DisplayName("It should previous validation to the company")
    void shouldValidationCompany() {
        Company company = new CompanyTestDataBuilder().withId(1).build();
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        Mockito.when(companyRepository.existById(Mockito.anyInt())).thenReturn(false);

        UpdateCompanyService updateCompanyService = new UpdateCompanyService(companyRepository);
        BasePrueba.assertThrows(() -> updateCompanyService.ejecutar(company), ExcepcionDuplicidad.class,"The company doesn't exist");
    }


    @Test
    @DisplayName("It should successfully update company in the respository")
    void shouldUpdateSuccefullCompany() {
        Company company = new CompanyTestDataBuilder().withId(1).build();
        CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
        Mockito.when(companyRepository.existById(Mockito.anyInt())).thenReturn(true);

        UpdateCompanyService updateCompanyService = new UpdateCompanyService(companyRepository);
        updateCompanyService.ejecutar(company);

        Mockito.verify(companyRepository, Mockito.times(1)).actualizar(company);

    }

}

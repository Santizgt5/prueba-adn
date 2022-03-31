package com.ceiba.company.entity;

import com.ceiba.BasePrueba;
import com.ceiba.company.model.entity.Company;
import com.ceiba.company.servicio.testdatabuilder.CompanyTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompany {

    @Test
    @DisplayName("It should successfully create the company")
    void shouldCreateSuccesfullCompany() {

        LocalDate born = LocalDate.now();

        Company company = new CompanyTestDataBuilder().withBorn(born).withId(1).build();

        assertEquals(1, company.getId());
        assertEquals("Bungie", company.getName());
        assertEquals("Descripcion de prueba", company.getDescription());
        assertEquals(born, company.getBorn());
        assertEquals("1234", company.getNit());

    }

    @Test
    void shoulFailWithoutName() {

        CompanyTestDataBuilder companyTestDataBuilder = new CompanyTestDataBuilder().withName(null).withId(1);

        BasePrueba.assertThrows(() -> {
            companyTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Name must entered");

    }

    @Test
    void shoulFailWithoutDescription() {

        CompanyTestDataBuilder companyTestDataBuilder = new CompanyTestDataBuilder().withDescription(null).withId(1);

        BasePrueba.assertThrows(() -> {
            companyTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Description must entered");

    }

    @Test
    void shoulFailWithoutBorn() {

        CompanyTestDataBuilder companyTestDataBuilder = new CompanyTestDataBuilder().withBorn(null).withId(1);

        BasePrueba.assertThrows(() -> {
            companyTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Born must entered");

    }

    @Test
    void shoulFailWithoutNit() {

        CompanyTestDataBuilder companyTestDataBuilder = new CompanyTestDataBuilder().withNit(null).withId(1);

        BasePrueba.assertThrows(() -> {
            companyTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Nit must entered");

    }



}

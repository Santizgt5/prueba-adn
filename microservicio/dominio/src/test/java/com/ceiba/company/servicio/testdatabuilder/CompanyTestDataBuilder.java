package com.ceiba.company.servicio.testdatabuilder;

import com.ceiba.company.model.entity.Company;

import java.time.LocalDate;

public class CompanyTestDataBuilder {

    private int id;
    private String name;
    private String description;
    private LocalDate born;
    private String nit;

    public CompanyTestDataBuilder() {
        name = "Bungie";
        description = "Descripcion de prueba";
        born = LocalDate.now();
        nit = "1234";
    }

    public CompanyTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CompanyTestDataBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CompanyTestDataBuilder withBorn(LocalDate born) {
        this.born = born;
        return this;
    }

    public CompanyTestDataBuilder withNit(String nit) {
        this.nit = nit;
        return this;
    }

    public CompanyTestDataBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public Company build() { return new Company(id, name, description, born, nit); }




}

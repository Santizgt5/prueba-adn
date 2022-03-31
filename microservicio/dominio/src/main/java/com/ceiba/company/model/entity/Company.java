package com.ceiba.company.model.entity;

import lombok.Getter;

import java.time.LocalDate;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Company {

    private static final String NAME_MUST_BE_ENTERED = "Name must entered";
    private static final String DESCRIPTION_MUST_BE_ENTERED = "Description must entered";
    private static final String BORN_MUST_BE_ENTERED = "Born must entered";
    private static final String NIT_MUST_BE_ENTERED = "Nit must entered";

    private int id;
    private String name;
    private String description;
    private LocalDate born;
    private String nit;

    public Company(int id, String name, String description, LocalDate born, String nit) {
        validarObligatorio(name, NAME_MUST_BE_ENTERED);
        validarObligatorio(description, DESCRIPTION_MUST_BE_ENTERED);
        validarObligatorio(born, BORN_MUST_BE_ENTERED);
        validarObligatorio(nit, NIT_MUST_BE_ENTERED);


        this.id = id;
        this.name = name;
        this.description = description;
        this.born = born;
        this.nit = nit;
    }
}

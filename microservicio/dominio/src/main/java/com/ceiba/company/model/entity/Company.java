package com.ceiba.company.model.entity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Company {

    private int id;
    private String name;
    private String description;
    private LocalDate born;
    private String nit;

    public Company(int id, String name, String description, LocalDate born, String nit) {
        //TODO Add validations

        this.id = id;
        this.name = name;
        this.description = description;
        this.born = born;
        this.nit = nit;
    }
}

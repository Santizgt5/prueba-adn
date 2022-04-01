package com.ceiba.company.service.testdatabuilder;

import com.ceiba.company.command.CommandCompany;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TestDataBuilderCommandCompany {

    private int id;
    private String name;
    private String description;
    private LocalDate born;
    private String nit;

    public TestDataBuilderCommandCompany() {
        name = UUID.randomUUID().toString();
        description = UUID.randomUUID().toString();
        born = LocalDate.now();
        nit = "1234";
    }

    public TestDataBuilderCommandCompany withName(String name) {
        this.name = name;
        return this;
    }

    public CommandCompany build() { return new CommandCompany(id, name, description, born, nit); }

}

package com.ceiba.company.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCompany {

    private int id;
    private String name;
    private String description;
    private LocalDate born;
    private String nit;

}

package com.ceiba.videogame.model.dto;

import com.ceiba.company.model.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DtoVideogame {

    private int id;
    private String title;
    private int stock;
    private int companyId;
    private Company company;
    private LocalDate releaseDate;
    private String platform;
    private double price;
    private double priceWithDiscountMonth;
    private double priceWithDiscountQuantity;

}

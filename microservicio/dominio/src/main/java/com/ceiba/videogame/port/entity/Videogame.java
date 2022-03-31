package com.ceiba.videogame.port.entity;

import com.ceiba.company.model.entity.Company;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Videogame {

    public final static double DISCOUNT_MONTH = 0.10;

    private int id;
    private String title;
    private int stock;
    private Company company;
    private LocalDate releaseDate;
    private String platform;
    private double price;
    private double priceWithDiscountMonth;
    private double priceWithDiscountQuantity;

    public Videogame(int id, String title, int stock, Company company, LocalDate releaseDate, String platform, double price) {
        //TODO Add validations

        this.id = id;
        this.title = title;
        this.stock = stock;
        this.company = company;
        this.releaseDate = releaseDate;
        this.platform = platform;
        this.price = price;
        this.priceWithDiscountMonth = 0;
        this.priceWithDiscountQuantity = 0;
    }
}

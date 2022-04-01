package com.ceiba.videogame.model.entity;

import com.ceiba.company.model.entity.Company;
import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Videogame {

    public final static double DISCOUNT_MONTH = 0.10;

    private static final String TITLE_MUST_BE_ENTERED = "Title must entered";
    private static final String STOCK_MUST_BE_ENTERED = "Stock must entered";
    private static final String COMPANY_MUST_BE_ENTERED = "Company must entered";
    private static final String RELEASE_DATE_MUST_BE_ENTERED = "Release date must entered";
    private static final String PLATFORM_MUST_BE_ENTERED = "Platform must entered";
    private static final String PRICE_DATE_MUST_BE_ENTERED = "Price must entered";


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
        validarObligatorio(title, TITLE_MUST_BE_ENTERED);
        validarObligatorioInteger(stock, STOCK_MUST_BE_ENTERED);
        validarObligatorio(company, COMPANY_MUST_BE_ENTERED);
        validarObligatorio(releaseDate, RELEASE_DATE_MUST_BE_ENTERED);
        validarObligatorio(platform, PLATFORM_MUST_BE_ENTERED);
        validarObligatorioDouble(price, PRICE_DATE_MUST_BE_ENTERED);


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

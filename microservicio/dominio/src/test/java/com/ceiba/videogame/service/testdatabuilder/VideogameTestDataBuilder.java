package com.ceiba.videogame.service.testdatabuilder;

import com.ceiba.company.model.entity.Company;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.model.entity.Videogame;

import java.time.LocalDate;

public class VideogameTestDataBuilder {

    private int id;
    private String title;
    private int stock;
    private Company company;
    private int companyId;
    private LocalDate releaseDate;
    private String platform;
    private double price;

    public VideogameTestDataBuilder() {
        title = "Halo";
        stock = 10;
        company = new Company(1, "Bungie", "Descripcion de prueba", LocalDate.now(), "1234");
        releaseDate = LocalDate.now();
        platform = "Xbox";
        price = 150000;
        companyId = 2;
    }

    public VideogameTestDataBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public VideogameTestDataBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public VideogameTestDataBuilder withStock(int stock) {
        this.stock = stock;
        return this;
    }

    public VideogameTestDataBuilder withReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public VideogameTestDataBuilder withCompany(Company company) {
        this.company = company;
        return this;
    }

    public VideogameTestDataBuilder withPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public VideogameTestDataBuilder withPrice(double price) {
        this.price = price;
        return this;
    }
    public Videogame build() { return new Videogame(id,title, stock, company, releaseDate, platform, price ); }

    public DtoVideogame buildDto() { return  new DtoVideogame(id, title, stock, companyId , company, releaseDate, platform, price, 0, 0 ); }


}

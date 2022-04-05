package com.ceiba.videogame.service.testdatabuilder;



import com.ceiba.videogame.command.CommandVideogame;

import java.time.LocalDate;
import java.time.Month;




public class TestDataBuilderCommandVideogame {

    private int id;
    private String title;
    private int stock;
    private int companyId;
    private LocalDate releaseDate;
    private String platform;
    private double price;

    public TestDataBuilderCommandVideogame() {
        title = "God of war";
        stock = 10;
        companyId = 1;
        releaseDate = LocalDate.of(2019, Month.JANUARY, 8);
        platform = "PC";
        price = 150000;
    }

    public CommandVideogame build() { return new CommandVideogame(id, title, stock, companyId, releaseDate, platform, price); }





}

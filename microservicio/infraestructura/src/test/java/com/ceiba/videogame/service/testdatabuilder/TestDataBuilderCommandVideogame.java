package com.ceiba.videogame.service.testdatabuilder;



import com.ceiba.videogame.command.CommandVideogame;

import java.time.LocalDate;
import java.util.UUID;




public class TestDataBuilderCommandVideogame {

    private int id;
    private String title;
    private int stock;
    private int companyId;
    private LocalDate releaseDate;
    private String platform;
    private double price;

    public TestDataBuilderCommandVideogame() {
        title = UUID.randomUUID().toString();
        stock = 10;
        companyId = 1;
        releaseDate = LocalDate.now();
        platform = "PC";
        price = 150000;
    }

    public CommandVideogame build() { return new CommandVideogame(id, title, stock, companyId, releaseDate, platform, price); }





}

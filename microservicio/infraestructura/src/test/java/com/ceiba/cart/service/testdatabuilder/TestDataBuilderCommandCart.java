package com.ceiba.cart.service.testdatabuilder;

import com.ceiba.cart.command.CommandCart;
import com.ceiba.videogamepurchase.command.CommandVideogamePurchase;

import java.util.List;

public class TestDataBuilderCommandCart {

    private int id;
    private double total;
    private  int cantidadTotal;
    private List<CommandVideogamePurchase> videogames;

    public TestDataBuilderCommandCart() {
        total = 300000;
        cantidadTotal = 2;
    }

    public TestDataBuilderCommandCart withVideogames(List<CommandVideogamePurchase> videogames) {
        this.videogames = videogames;
        return this;
    }

    public CommandCart build() {return new CommandCart(id, total, cantidadTotal,videogames); }

}

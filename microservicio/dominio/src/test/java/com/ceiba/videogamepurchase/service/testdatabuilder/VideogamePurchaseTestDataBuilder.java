package com.ceiba.videogamepurchase.service.testdatabuilder;

import com.ceiba.videogamepurchase.model.entity.VideogamePurchase;

public class VideogamePurchaseTestDataBuilder {

    private int id;
    private String videogame;
    private int quantity;
    private double price;

    public VideogamePurchaseTestDataBuilder() {
        videogame = "Halo";
        quantity = 1;
        price = 150000;
    }

    public VideogamePurchaseTestDataBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public VideogamePurchaseTestDataBuilder withVideogame(String videogame) {
        this.videogame= videogame;
        return this;
    }

    public VideogamePurchaseTestDataBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public VideogamePurchaseTestDataBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public VideogamePurchase build() { return new VideogamePurchase(id, videogame, quantity, price); }



}

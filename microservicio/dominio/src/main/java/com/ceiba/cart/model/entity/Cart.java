package com.ceiba.cart.model.entity;

import java.util.List;

public class Cart {

    private int id;
    private double total;
    private List<VideogamePurchase> videogames;

    public Cart(int id, double total, List<VideogamePurchase> videogames) {
        //TODO Add validations

        this.id = id;
        this.total = total;
        this.videogames = videogames;
    }
}

package com.ceiba.cart.model.entity;

import com.ceiba.videogame.model.entity.Videogame;

public class VideogamePurchase {

    private String videogame;
    private int quantity;

    public VideogamePurchase(String videogame, int quantity) {
        //TODO Add validaciones

        this.videogame = videogame;
        this.quantity = quantity;
    }
}

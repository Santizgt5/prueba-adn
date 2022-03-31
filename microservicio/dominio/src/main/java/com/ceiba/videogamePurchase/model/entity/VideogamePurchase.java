package com.ceiba.videogamePurchase.model.entity;

import com.ceiba.cart.model.entity.Cart;
import lombok.Getter;

@Getter
public class VideogamePurchase {

    private int id;
    private String videogame;
    private int quantity;
    private double price;
    private double priceWithDiscount;

    public VideogamePurchase(int id, String videogame, int quantity, double price) {

        this.id = id;
        this.videogame = videogame;
        this.quantity = quantity;
        this.price = price;
        this.priceWithDiscount = 0;
    }
}

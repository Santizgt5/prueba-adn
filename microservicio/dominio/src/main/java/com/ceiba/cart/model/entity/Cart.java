package com.ceiba.cart.model.entity;

import com.ceiba.videogamePurchase.model.entity.VideogamePurchase;
import lombok.Getter;

import java.util.List;

@Getter
public class Cart {

    public final static double DISCOUNT_MONDAY = 0.20;

    private int id;
    private double total;
    private int cantidadTotal;
    private List<VideogamePurchase> videogames;

    public Cart(int id, double total, int cantidadTotal, List<VideogamePurchase> videogames ) {
        //TODO Add validations

        this.id = id;
        this.total = total;
        this.videogames = videogames;
        this.cantidadTotal = cantidadTotal;
    }
}

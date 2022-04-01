package com.ceiba.cart.service.testdatabuilder;

import com.ceiba.cart.model.entity.Cart;
import com.ceiba.videogame.service.testdatabuilder.VideogameTestDataBuilder;
import com.ceiba.videogamePurchase.model.entity.VideogamePurchase;

import java.util.ArrayList;
import java.util.List;

public class CartTestDataBuilder {

    private int id;
    private double total;
    private int totalQuantity;
    private List<VideogamePurchase> videogames;

    public CartTestDataBuilder() {
        total = 150000;
        totalQuantity = 1;
        videogames = createListVideogamePurchase();
    }

    private List<VideogamePurchase> createListVideogamePurchase() {
        List<VideogamePurchase> videogamePurchases = new ArrayList<>();
        VideogamePurchase videogamePurchase = new VideogamePurchase(1, "Halo", 1, 150000);
        videogamePurchases.add(videogamePurchase);
        return videogamePurchases;
    }

    public CartTestDataBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CartTestDataBuilder withTotal(double total) {
        this.total = total;
        return this;
    }

    public CartTestDataBuilder witTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
        return this;
    }

    public CartTestDataBuilder withVideogame(List<VideogamePurchase> videogames) {
        this.videogames = videogames;
        return this;
    }

    public Cart build() { return new Cart(id, total, totalQuantity, videogames);  }



}

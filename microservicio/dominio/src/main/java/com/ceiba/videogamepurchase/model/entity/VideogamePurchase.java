package com.ceiba.videogamepurchase.model.entity;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class VideogamePurchase {

    private static final String VIDEOGAME_MUST_BE_ENTERED = "Videogame must entered";
    private static final String QUANTITY_MUST_BE_ENTERED = "Quantity must entered";
    private static final String PRICE_MUST_BE_ENTERED = "Price must entered";


    private int id;
    private String videogame;
    private int quantity;
    private double price;

    public VideogamePurchase(int id, String videogame, int quantity, double price) {
        validarObligatorio(videogame, VIDEOGAME_MUST_BE_ENTERED);
        validarObligatorioInteger(quantity, QUANTITY_MUST_BE_ENTERED);
        validarObligatorioDouble(price, PRICE_MUST_BE_ENTERED);

        this.id = id;
        this.videogame = videogame;
        this.quantity = quantity;
        this.price = price;
    }
}

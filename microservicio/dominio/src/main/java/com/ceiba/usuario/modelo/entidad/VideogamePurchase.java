package com.ceiba.usuario.modelo.entidad;

import com.ceiba.videogame.model.entity.Videogame;

public class VideogamePurchase {

    private Videogame videogame;
    private int quantity;

    public VideogamePurchase(Videogame videogame, int quantity) {
        //TODO Add validaciones

        this.videogame = videogame;
        this.quantity = quantity;
    }
}

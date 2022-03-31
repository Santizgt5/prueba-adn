package com.ceiba.videogamePurchase.command.factory;

import com.ceiba.videogamePurchase.command.CommandVideogamePurchase;
import com.ceiba.videogamePurchase.model.dto.DtoVideogamePurchase;

public class VideogamePurchaseFactory {

    public DtoVideogamePurchase crear(CommandVideogamePurchase commandVideogamePurchase){
        return DtoVideogamePurchase.builder().id(commandVideogamePurchase.getId()).videogame(commandVideogamePurchase.getVideogame())
                .quantity(commandVideogamePurchase.getQuantity()).price(commandVideogamePurchase.getPrice()).videogameId(commandVideogamePurchase.getVideogameId()).build();
    }

}

package com.ceiba.videogamepurchase.command.factory;

import com.ceiba.videogamepurchase.command.CommandVideogamePurchase;
import com.ceiba.videogamepurchase.model.dto.DtoVideogamePurchase;

public class VideogamePurchaseFactory {

    public DtoVideogamePurchase crear(CommandVideogamePurchase commandVideogamePurchase){
        return DtoVideogamePurchase.builder().id(commandVideogamePurchase.getId()).videogame(commandVideogamePurchase.getVideogame())
                .quantity(commandVideogamePurchase.getQuantity()).price(commandVideogamePurchase.getPrice()).videogameId(commandVideogamePurchase.getVideogameId()).build();
    }

}

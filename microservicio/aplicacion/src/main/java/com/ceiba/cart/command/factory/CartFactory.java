package com.ceiba.cart.command.factory;

import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.videogame.command.factory.VideogameFactory;
import com.ceiba.videogamePurchase.command.factory.VideogamePurchaseFactory;
import com.ceiba.videogamePurchase.model.dto.DtoVideogamePurchase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartFactory {

    public DtoCart crear(CommandCart commandCart) {
        VideogamePurchaseFactory videogamePurchaseFactory = new VideogamePurchaseFactory();
        List<DtoVideogamePurchase> videogames = new ArrayList<DtoVideogamePurchase>();
        commandCart.getVideogames().forEach(dtoVideogamePurchase -> {
            DtoVideogamePurchase videogame = videogamePurchaseFactory.crear(dtoVideogamePurchase);
            videogames.add(videogame);
        });
       return new DtoCart(
               commandCart.getId(),
               commandCart.getTotal(),
               commandCart.getCantidadTotal(),
               videogames
       );
    }

}

package com.ceiba.cart.command.factory;

import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.videogamepurchase.command.factory.VideogamePurchaseFactory;
import com.ceiba.videogamepurchase.model.dto.DtoVideogamePurchase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartFactory {

    public DtoCart crear(CommandCart commandCart) {
        VideogamePurchaseFactory videogamePurchaseFactory = new VideogamePurchaseFactory();
        List<DtoVideogamePurchase> videogames = new ArrayList<>();
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

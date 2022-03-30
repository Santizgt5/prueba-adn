package com.ceiba.cart.command.factory;

import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.model.dto.DtoCart;
import org.springframework.stereotype.Component;

@Component
public class CartFactory {

    public DtoCart crear(CommandCart commandCart) {
        return DtoCart.builder().id(commandCart.getId()).total(commandCart.getTotal())
                .videogames(commandCart.getVideogames()).build();
    }

}

package com.ceiba.cart.command.handler;

import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.command.factory.CartFactory;
import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.cart.service.BuyVideogamesService;
import org.springframework.stereotype.Component;

@Component
public class BuyVideogameHandler {

    private final CartFactory cartFactory;
    private final BuyVideogamesService buyVideogamesService;


    public BuyVideogameHandler(CartFactory cartFactory, BuyVideogamesService buyVideogamesService) {
        this.cartFactory = cartFactory;
        this.buyVideogamesService = buyVideogamesService;
    }

    public void ejecutar(CommandCart commandCart) {
        DtoCart cart = this.cartFactory.crear(commandCart);
        this.buyVideogamesService.ejecutar(cart);
    }

}

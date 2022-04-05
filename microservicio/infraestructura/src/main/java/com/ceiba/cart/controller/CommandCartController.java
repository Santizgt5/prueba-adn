package com.ceiba.cart.controller;

import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.command.handler.BuyVideogameHandler;
import com.ceiba.cart.command.handler.DiscountMondayCartHandler;
import com.ceiba.cart.model.dto.DtoCart;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CommandCartController {

    private final DiscountMondayCartHandler createCartHandler;
    private final BuyVideogameHandler buyVideogameHandler;


    public CommandCartController(DiscountMondayCartHandler createCartHandler, BuyVideogameHandler buyVideogameHandler) {
        this.createCartHandler = createCartHandler;
        this.buyVideogameHandler = buyVideogameHandler;
    }

    @PostMapping(value = "/calculateDiscount")
    public DtoCart calculateDiscountMonday(@RequestBody CommandCart commandCart) {
        return createCartHandler.ejecutar(commandCart);
    }

    @PostMapping(value = "/buy")
    public void buyVideogames(@RequestBody CommandCart commandCart) {
        buyVideogameHandler.ejecutar(commandCart);
    }



}

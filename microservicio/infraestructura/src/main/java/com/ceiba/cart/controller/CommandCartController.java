package com.ceiba.cart.controller;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.command.handler.CreateCartHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CommandCartController {

    private final CreateCartHandler createCartHandler;


    public CommandCartController(CreateCartHandler createCartHandler) {
        this.createCartHandler = createCartHandler;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody CommandCart commandCart) {
        return createCartHandler.ejecutar(commandCart);
    }
}

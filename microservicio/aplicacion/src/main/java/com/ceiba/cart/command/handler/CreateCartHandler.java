package com.ceiba.cart.command.handler;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.command.factory.CartFactory;
import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.cart.service.CreateCartService;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class CreateCartHandler implements ManejadorComandoRespuesta<CommandCart, ComandoRespuesta<Integer>> {

    private final CartFactory cartFactory;
    private final CreateCartService createCartService;


    public CreateCartHandler(CartFactory cartFactory,CreateCartService createCartService) {
        this.cartFactory = cartFactory;
        this.createCartService = createCartService;
    }


    @Override
    public ComandoRespuesta<Integer> ejecutar(CommandCart commandCart) {
        DtoCart cart = this.cartFactory.crear(commandCart);
        return new ComandoRespuesta<>(this.createCartService.ejecutar(cart));
    }
}

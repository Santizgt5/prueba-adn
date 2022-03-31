package com.ceiba.cart.command.handler;

import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.command.factory.CartFactory;
import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.cart.service.CalcuateQuantityDiscountService;
import org.springframework.stereotype.Component;


@Component
public class DiscountMondayCartHandler {

    private final CartFactory cartFactory;
    private final CalcuateQuantityDiscountService calcuateQuantityDiscountService;

    public DiscountMondayCartHandler(CartFactory cartFactory, CalcuateQuantityDiscountService calcuateQuantityDiscountService) {
        this.cartFactory = cartFactory;
        this.calcuateQuantityDiscountService = calcuateQuantityDiscountService;
    }


    public DtoCart ejecutar(CommandCart commandCart) {
        DtoCart cart = this.cartFactory.crear(commandCart);
        return this.calcuateQuantityDiscountService.ejecutar(cart);
    }
}

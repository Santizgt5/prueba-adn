package com.ceiba.cart.service;

import com.ceiba.cart.CartValidations;
import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.cart.model.entity.Cart;

import java.util.Calendar;


public class CalcuateQuantityDiscountService {

    private final CartValidations cartValidations;

    public CalcuateQuantityDiscountService(CartValidations cartValidations) {
        this.cartValidations = cartValidations;
    }

    public DtoCart ejecutar(DtoCart cart) {
        if (cartValidations.mondayValidation()) {
            if(cart.getCantidadTotal() >= 2) {
                double totalWithDiscount = cart.getTotal() - (cart.getTotal() * Cart.DISCOUNT_MONDAY);
                cart.setTotal(totalWithDiscount);
            }
        }
        return cart;
    }

}

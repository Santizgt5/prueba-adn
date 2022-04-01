package com.ceiba.cart.service;

import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.cart.model.entity.Cart;

import java.time.LocalDate;
import java.util.Calendar;


public class CalcuateQuantityDiscountService {


    public DtoCart ejecutar(DtoCart cart) {
        Calendar today = Calendar.getInstance();
        int day = today.get(Calendar.DAY_OF_WEEK);
        if (day==2) {
            if(cart.getCantidadTotal() >= 2) {
                double totalWithDiscount = cart.getTotal() - (cart.getTotal() * Cart.DISCOUNT_MONDAY);
                cart.setTotal(totalWithDiscount);
            }
        }
        return cart;
    }

}

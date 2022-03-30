package com.ceiba.cart.service;

import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.cart.port.repository.CartRepository;


public class CreateCartService {

    private final CartRepository cartRepository;

    public CreateCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public int ejecutar(DtoCart cart) {
        return this.cartRepository.crear(cart);
    }

}

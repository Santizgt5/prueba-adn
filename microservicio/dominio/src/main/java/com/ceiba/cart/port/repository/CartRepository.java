package com.ceiba.cart.port.repository;

import com.ceiba.cart.model.entity.Cart;

public interface CartRepository {

    /**
     * Permite crear un usuario
     * @param cart
     * @return el id generado
     */
    int crear(Cart cart);


}

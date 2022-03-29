package com.ceiba.cart.port.dao;

import com.ceiba.cart.model.dto.DtoCart;

import java.util.List;

public interface DaoCart {

    /**
     * Permite listar los carritos de compra
     * @return carts
     */
    List<DtoCart> listar();


}

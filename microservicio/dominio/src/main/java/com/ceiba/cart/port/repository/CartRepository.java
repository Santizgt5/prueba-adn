package com.ceiba.cart.port.repository;

import com.ceiba.cart.model.entity.Cart;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface CartRepository {

    /**
     * Permite crear un usuario
     * @param cart
     * @return el id generado
     */
    Long crear(Cart cart);

    /**
     * Permite actualizar un usuario
     * @param cart
     */
    void actualizar(Cart cart);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(int id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}

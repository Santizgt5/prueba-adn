package com.ceiba.cart.service;

import com.ceiba.cart.CartValidations;
import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.dominio.excepcion.WeekendException;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;
import com.ceiba.videogamepurchase.model.dto.DtoVideogamePurchase;

import java.util.List;

public class BuyVideogamesService {

    private static final String IS_WEEKEND = "Today is weekend, you can't buy";

    private final VideogameRepository videogameRepository;
    private final CartValidations cartValidations;

    public BuyVideogamesService(VideogameRepository videogameRepository, CartValidations cartValidations) {
        this.videogameRepository = videogameRepository;
        this.cartValidations = cartValidations;
    }

    public void ejecutar(DtoCart cart) {
        if( !cartValidations.weekendValidation() ) {
            List<DtoVideogamePurchase> videogameList = cart.getVideogames();
            videogameList.forEach(dtoVideogamePurchase -> {
                DtoVideogame actual = this.videogameRepository.getVideogameById(dtoVideogamePurchase.getVideogameId());
                actual.setStock(actual.getStock() - dtoVideogamePurchase.getQuantity());
                this.videogameRepository.actualizar(actual);
            });
        } else {
            throw new WeekendException(IS_WEEKEND);
        }
    }

}

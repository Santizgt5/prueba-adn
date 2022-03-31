package com.ceiba.videogame.query;

import java.util.List;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.service.VerifyDiscountService;
import org.springframework.stereotype.Component;

@Component
public class HandlerListVideogames {


    private final VerifyDiscountService verifyDiscountService;

    public HandlerListVideogames(VerifyDiscountService verifyDiscountService) {
        this.verifyDiscountService = verifyDiscountService;
    }


    public List<DtoVideogame> ejecutar(){
        return this.verifyDiscountService.ejecutar();
    }


}

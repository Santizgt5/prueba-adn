package com.ceiba.videogame.service;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.dao.DaoVideogame;
import com.ceiba.videogame.port.entity.Videogame;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class VerifyDiscountService {

    private final DaoVideogame daoVideogame;


    public VerifyDiscountService(DaoVideogame daoVideogame) {
        this.daoVideogame = daoVideogame;
    }

    public List<DtoVideogame> ejecutar() {
        return calculateDiscountMonday(this.daoVideogame.listar());
    }

    public List<DtoVideogame> calculateDiscountMonday(List<DtoVideogame> videogames) {
       LocalDate currentDate = LocalDate.now();
       videogames.forEach(videogame -> {
           if(ChronoUnit.DAYS.between(videogame.getReleaseDate(), currentDate) <= 31 ) {
               double total = videogame.getPrice() - (videogame.getPrice() * Videogame.DISCOUNT_MONTH );
               videogame.setPriceWithDiscountMonth(total);
           }
       });
       return videogames;
    }



}

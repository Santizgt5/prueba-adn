package com.ceiba.cart.service;

import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.dominio.excepcion.WeekendException;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;
import com.ceiba.videogamePurchase.model.dto.DtoVideogamePurchase;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class BuyVideogamesService {

    private static final String IS_WEEKEND = "Today is weekend, you can't buy";

    private final VideogameRepository videogameRepository;

    public BuyVideogamesService(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    public void ejecutar(DtoCart cart) {
        validarWekeend();
        List<DtoVideogamePurchase> videogameList = cart.getVideogames();
        videogameList.forEach(dtoVideogamePurchase -> {
            DtoVideogame actual = this.videogameRepository.getVideogameById(dtoVideogamePurchase.getVideogameId());
            actual.setStock(actual.getStock() - dtoVideogamePurchase.getQuantity());
            this.videogameRepository.actualizar(actual);
        });
    }

    private void validarWekeend() {
        LocalDate dateNow = LocalDate.now();
        Calendar today = Calendar.getInstance();
        today.set(dateNow.getYear(), dateNow.getMonthValue(), dateNow.getDayOfMonth());
        int day = today.get(Calendar.DAY_OF_WEEK);
        if(day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
            throw new WeekendException(IS_WEEKEND);
        }
    }

}

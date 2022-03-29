package com.ceiba.videogame.service;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.model.entity.Videogame;
import com.ceiba.videogame.port.repository.VideogameRepository;

public class BuyVideogameService {

    private final VideogameRepository videogameRepository;

    public BuyVideogameService(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    public void ejecutar(DtoVideogame videogame) {
        this.videogameRepository.actualizar(videogame);
    }


}

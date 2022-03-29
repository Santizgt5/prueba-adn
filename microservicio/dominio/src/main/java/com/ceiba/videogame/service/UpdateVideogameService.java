package com.ceiba.videogame.service;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;

public class UpdateVideogameService {

    private final VideogameRepository videogameRepository;

    public UpdateVideogameService(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }


    public void ejecutar(DtoVideogame videogame) {
        this.videogameRepository.actualizar(videogame);
    }

}

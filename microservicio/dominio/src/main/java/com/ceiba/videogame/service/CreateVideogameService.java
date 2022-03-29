package com.ceiba.videogame.service;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;

public class CreateVideogameService {

    private final VideogameRepository videogameRepository;

    public CreateVideogameService(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    public int ejecutar(DtoVideogame videogame) {
        return this.videogameRepository.crear(videogame);
    }

}

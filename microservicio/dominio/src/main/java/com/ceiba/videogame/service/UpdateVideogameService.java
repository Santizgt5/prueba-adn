package com.ceiba.videogame.service;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;

public class UpdateVideogameService {

    private static final String VIDEOGAME_DOESNT_EXIST = "The videogame doesn't exist";

    private final VideogameRepository videogameRepository;

    public UpdateVideogameService(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }


    public void ejecutar(DtoVideogame videogame) {
        existValidation(videogame);
        this.videogameRepository.actualizar(videogame);
    }

    private void existValidation(DtoVideogame videogame) {
        boolean exist = this.videogameRepository.existById(videogame.getId());
        if(!exist) {
            throw new ExcepcionDuplicidad(VIDEOGAME_DOESNT_EXIST);
        }
    }

}

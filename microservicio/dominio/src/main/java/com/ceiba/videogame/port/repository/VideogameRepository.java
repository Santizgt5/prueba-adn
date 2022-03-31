package com.ceiba.videogame.port.repository;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.entity.Videogame;

public interface VideogameRepository {

    /**
     * Permite crear un usuario
     * @param videogame
     * @return el id generado
     */
    int crear(DtoVideogame videogame);

    /**
     * Permite actualizar un usuario
     * @param videogame
     */
    void actualizar(DtoVideogame videogame);


    /**
     * Return videogame by id
     * @param id
     * @return Videogame
     */
    DtoVideogame getVideogameById(int id);

}

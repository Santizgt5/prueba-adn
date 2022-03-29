package com.ceiba.videogame.port.repository;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.model.entity.Videogame;

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
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(int id);

}

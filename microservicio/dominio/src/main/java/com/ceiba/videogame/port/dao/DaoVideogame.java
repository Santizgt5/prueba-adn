package com.ceiba.videogame.port.dao;


import com.ceiba.videogame.model.entity.Videogame;

import java.util.List;

public interface DaoVideogame {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<Videogame> listar();

}

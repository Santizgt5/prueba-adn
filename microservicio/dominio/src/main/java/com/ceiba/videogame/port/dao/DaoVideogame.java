package com.ceiba.videogame.port.dao;


import com.ceiba.videogame.model.dto.DtoVideogame;

import java.util.List;

public interface DaoVideogame {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoVideogame> listar();

}

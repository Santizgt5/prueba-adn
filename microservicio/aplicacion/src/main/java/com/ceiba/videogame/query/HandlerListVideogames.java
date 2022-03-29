package com.ceiba.videogame.query;

import java.util.List;

import com.ceiba.videogame.model.entity.Videogame;
import com.ceiba.videogame.port.dao.DaoVideogame;
import org.springframework.stereotype.Component;

@Component
public class HandlerListVideogames {

    private final DaoVideogame daoVideogame;

    public HandlerListVideogames(DaoVideogame daoVideogame) {
        this.daoVideogame = daoVideogame;
    }


    public List<Videogame> ejecutar(){ return this.daoVideogame.listar(); }
}

package com.ceiba.videogame.controller;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.query.HandlerListVideogames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videogames")
public class QueryControllerVideogame {

    private final HandlerListVideogames handlerListVideogames;

    public QueryControllerVideogame(HandlerListVideogames handlerListVideogames) {
        this.handlerListVideogames = handlerListVideogames;
    }


    @GetMapping
    public List<DtoVideogame> listar() {
        return this.handlerListVideogames.ejecutar();
    }

}

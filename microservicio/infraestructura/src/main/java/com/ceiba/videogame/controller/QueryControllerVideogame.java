package com.ceiba.videogame.controller;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.videogame.model.entity.Videogame;
import com.ceiba.videogame.query.HandlerListVideogames;
import io.swagger.annotations.ApiOperation;
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
    public List<Videogame> listar() {
        return this.handlerListVideogames.ejecutar();
    }

}

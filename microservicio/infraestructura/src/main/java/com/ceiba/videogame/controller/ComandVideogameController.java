package com.ceiba.videogame.controller;

import com.ceiba.ComandoRespuesta;
import com.ceiba.videogame.command.CommandVideogame;
import com.ceiba.videogame.command.handler.CreateVideogameHandler;
import com.ceiba.videogame.command.handler.UpdateVideogameHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videogame")
public class ComandVideogameController {

    private final CreateVideogameHandler createVideogameHandler;
    private final UpdateVideogameHandler updateVideogameHandler;


    public ComandVideogameController(CreateVideogameHandler createVideogameHandler, UpdateVideogameHandler updateVideogameHandler) {
        this.createVideogameHandler = createVideogameHandler;
        this.updateVideogameHandler = updateVideogameHandler;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody CommandVideogame commandVideogame) {
        return createVideogameHandler.ejecutar(commandVideogame);
    }

    @PutMapping(value="/{id}")
    public void actualizar(@RequestBody CommandVideogame commandVideogame, @PathVariable int id) {
        commandVideogame.setId(id);
        updateVideogameHandler.ejecutar(commandVideogame);
    }



}

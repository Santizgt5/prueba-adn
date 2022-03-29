package com.ceiba.videogame.command.handler;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.videogame.command.CommandVideogame;
import com.ceiba.videogame.command.factory.VideogameFactory;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.service.CreateVideogameService;
import org.springframework.stereotype.Component;

@Component
public class CreateVideogameHandler implements ManejadorComandoRespuesta<CommandVideogame, ComandoRespuesta<Integer>> {

    private final VideogameFactory videogameFactory;
    private final CreateVideogameService createVideogameService;

    public CreateVideogameHandler(VideogameFactory videogameFactory, CreateVideogameService createVideogameService) {
        this.videogameFactory = videogameFactory;
        this.createVideogameService = createVideogameService;
    }

    @Override
    public ComandoRespuesta<Integer> ejecutar(CommandVideogame comandVideogame) {
        DtoVideogame videogame = this.videogameFactory.crear(comandVideogame);
        return new ComandoRespuesta<>(this.createVideogameService.ejecutar(videogame));
    }
}

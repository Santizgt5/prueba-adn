package com.ceiba.videogame.command.handler;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.videogame.command.CommandVideogame;
import com.ceiba.videogame.command.factory.VideogameFactory;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.service.UpdateVideogameService;
import org.springframework.stereotype.Component;

@Component
public class UpdateVideogameHandler implements ManejadorComando<CommandVideogame> {

    private final VideogameFactory videogameFactory;
    private final UpdateVideogameService updateVideogameService;

    public UpdateVideogameHandler(VideogameFactory videogameFactory, UpdateVideogameService updateVideogameService) {
        this.videogameFactory = videogameFactory;
        this.updateVideogameService = updateVideogameService;
    }

    @Override
    public void ejecutar(CommandVideogame commandVideogame) {
        DtoVideogame videogame = this.videogameFactory.crear(commandVideogame);
        this.updateVideogameService.ejecutar(videogame);
    }
}

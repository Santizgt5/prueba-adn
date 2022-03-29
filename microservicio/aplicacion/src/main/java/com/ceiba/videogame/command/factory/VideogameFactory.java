package com.ceiba.videogame.command.factory;

import com.ceiba.videogame.command.CommandVideogame;
import com.ceiba.videogame.model.dto.DtoVideogame;
import org.springframework.stereotype.Component;

@Component
public class VideogameFactory {

    public DtoVideogame crear(CommandVideogame commandVideogame) {
        return DtoVideogame.builder().id(commandVideogame.getId()).title(commandVideogame.getTitle()).platform(commandVideogame.getPlatform()).companyId(commandVideogame.getCompanyId()).
                releaseDate(commandVideogame.getReleaseDate()).stock(commandVideogame.getStock()).price(commandVideogame.getPrice()).build();
    }

}

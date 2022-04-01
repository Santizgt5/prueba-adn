package com.ceiba.videogame.service;

import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;
import com.ceiba.videogame.service.testdatabuilder.VideogameTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class TestCreateVideogameService {

    @InjectMocks
    private CreateVideogameService createVideogameService;
    @Mock
    private VideogameRepository videogameRepository;

    @Test
    @DisplayName("It should successfully create company")
    void shouldCreateSuccefullCompany() {

        DtoVideogame dtoVideogame = new VideogameTestDataBuilder().buildDto();
        Mockito.when(videogameRepository.crear(dtoVideogame)).thenReturn(1);

        int videogameId =  this.createVideogameService.ejecutar(dtoVideogame);

        assertEquals(1, videogameId);
        Mockito.verify(videogameRepository, Mockito.times(1)).crear(dtoVideogame);

    }

}
package com.ceiba.videogame.service;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
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

@ExtendWith(SpringExtension.class)
public class TestUpdateVideogameService {

    @InjectMocks
    private UpdateVideogameService updateVideogameService;
    @Mock
    private VideogameRepository videogameRepository;

    @Test
    @DisplayName("It should previous validation to the company")
    void shouldValidationVideogame() {
        DtoVideogame videogame = new VideogameTestDataBuilder().withId(1).buildDto();
        Mockito.when(videogameRepository.existById(Mockito.anyInt())).thenReturn(false);

        BasePrueba.assertThrows(() -> updateVideogameService.ejecutar(videogame), ExcepcionDuplicidad.class,"The videogame doesn't exist");
    }


    @Test
    @DisplayName("It should successfully update company in the respository")
    void shouldUpdateSuccefullCompany() {
        DtoVideogame videogame = new VideogameTestDataBuilder().withId(1).buildDto();
        Mockito.when(videogameRepository.existById(Mockito.anyInt())).thenReturn(true);

        updateVideogameService.ejecutar(videogame);

        Mockito.verify(videogameRepository, Mockito.times(1)).actualizar(videogame);

    }


}

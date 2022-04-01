package com.ceiba.videogame.entity;

import com.ceiba.BasePrueba;
import com.ceiba.company.model.entity.Company;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.videogame.model.entity.Videogame;
import com.ceiba.videogame.service.testdatabuilder.VideogameTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVideogame {


    @Test
    @DisplayName("It should successfully create videogame")
    void shouldCreateSuccesfullCompany() {
        LocalDate releaseDate = LocalDate.now();

        Company company =  company = new Company(1, "Bungie", "Descripcion de prueba", LocalDate.now(), "1234");

        Videogame videogame = new VideogameTestDataBuilder().withReleaseDate(releaseDate).withCompany(company).withId(1).build();

        assertEquals(1, videogame.getId());
        assertEquals("Halo", videogame.getTitle());
        assertEquals(10,videogame.getStock());
        assertEquals(company, videogame.getCompany());
        assertEquals(releaseDate, videogame.getReleaseDate());
        assertEquals("Xbox", videogame.getPlatform());
        assertEquals(150000, videogame.getPrice());

    }

    @Test
    void shoulFailWithoutTitle() {

        VideogameTestDataBuilder videogameTestDataBuilder = new VideogameTestDataBuilder().withTitle(null).withId(1);

        BasePrueba.assertThrows(() -> {
            videogameTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Title must entered");

    }

    @Test
    void shoulFailWithoutStock() {

        VideogameTestDataBuilder videogameTestDataBuilder = new VideogameTestDataBuilder().withStock(0).withId(1);

        BasePrueba.assertThrows(() -> {
            videogameTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Stock must entered");

    }

    @Test
    void shoulFailWithoutCompany() {

        VideogameTestDataBuilder videogameTestDataBuilder = new VideogameTestDataBuilder().withCompany(null).withId(1);

        BasePrueba.assertThrows(() -> {
            videogameTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Company must entered");

    }

    @Test
    void shoulFailWithoutReleaseDate() {

        VideogameTestDataBuilder videogameTestDataBuilder = new VideogameTestDataBuilder().withReleaseDate(null).withId(1);

        BasePrueba.assertThrows(() -> {
            videogameTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Release date must entered");

    }

    @Test
    void shoulFailWithoutPlatform() {

        VideogameTestDataBuilder videogameTestDataBuilder = new VideogameTestDataBuilder().withPlatform(null).withId(1);

        BasePrueba.assertThrows(() -> {
            videogameTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Platform must entered");

    }

    @Test
    void shoulFailWithoutPrice() {

        VideogameTestDataBuilder videogameTestDataBuilder = new VideogameTestDataBuilder().withPrice(0).withId(1);

        BasePrueba.assertThrows(() -> {
            videogameTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Price must entered");

    }


}

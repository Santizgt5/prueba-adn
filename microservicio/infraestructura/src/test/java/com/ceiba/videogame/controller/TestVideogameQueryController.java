package com.ceiba.videogame.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.videogame.command.CommandVideogame;
import com.ceiba.videogame.service.testdatabuilder.TestDataBuilderCommandVideogame;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QueryControllerVideogame.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestVideogameQueryController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Sould list videogames")
    void shouldListVideogameWithDiscount() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/videogames")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("League of legends")))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].priceWithDiscountMonth", is(135000.0)));

    }

    @Test
    @DisplayName("Sould list videogames")
    void shouldListVideogameWithOutDiscount() throws Exception {
        CommandVideogame videogame = new TestDataBuilderCommandVideogame().build();

        mocMvc.perform(post("/videogame").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videogame))).andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));

        mocMvc.perform(get("/videogames")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].title", is("God of war")))
                .andExpect(jsonPath("$[1].id", is(3)))
                .andExpect(jsonPath("$[1].priceWithDiscountMonth", is(0.0)));

    }

}

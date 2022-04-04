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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CommandVideogameController.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestVideogameCommandController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("It should create a videogame")
    void shouldCreateCompany() throws Exception {

        CommandVideogame videogame = new TestDataBuilderCommandVideogame().build();

        mockMvc.perform(post("/videogame").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videogame))).andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));

    }

    @Test
    @DisplayName("It should update a company")
    void deberiaActualizarUnUsuario() throws Exception{
        // arrange
        int id = 2;
        CommandVideogame videogame = new TestDataBuilderCommandVideogame().build();
        // act - assert
        mockMvc.perform(put("/videogame/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videogame)))
                .andExpect(status().isOk());
    }

}

package com.ceiba.company.controller;


import com.ceiba.ApplicationMock;
import com.ceiba.company.command.CommandCompany;
import com.ceiba.company.service.testdatabuilder.TestDataBuilderCommandCompany;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CommandCompanyController.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestCompanyCommandController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("It should create a company")
    void shouldCreateCompany() throws Exception {

        CommandCompany company = new TestDataBuilderCommandCompany().build();

        mockMvc.perform(post("/company").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(company))).andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

    }

    @Test
    @DisplayName("It should update a company")
    void deberiaActualizarUnUsuario() throws Exception{
        // arrange
        int id = 1;
        CommandCompany company = new TestDataBuilderCommandCompany().build();
        // act - assert
        mockMvc.perform(put("/company/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(company)))
                .andExpect(status().isOk());
    }

}

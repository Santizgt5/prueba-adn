package com.ceiba.cart.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.cart.CartValidations;
import com.ceiba.cart.command.CommandCart;
import com.ceiba.cart.service.testdatabuilder.TestDataBuilderCommandCart;
import com.ceiba.videogame.command.CommandVideogame;
import com.ceiba.videogame.service.testdatabuilder.TestDataBuilderCommandVideogame;
import com.ceiba.videogamePurchase.command.CommandVideogamePurchase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CommandCartController.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestCartCommandController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CartValidations cartValidations;

    @Test
    @DisplayName("It should buy videogame")
    void shouldBuyVideogame() throws Exception {

        CommandVideogame videogame = new TestDataBuilderCommandVideogame().build();

        mockMvc.perform(post("/videogame").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videogame))).andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));

        List<CommandVideogamePurchase> videogames = new ArrayList<>();
        CommandVideogamePurchase videogame1 = new CommandVideogamePurchase(1, "League of legends", 2, 1, 150000);
        CommandVideogamePurchase videogame2 = new CommandVideogamePurchase(1, "God of war", 3, 1, 150000);
        videogames.add(videogame1);
        videogames.add(videogame2);

        CommandCart cart = new TestDataBuilderCommandCart().withVideogames(videogames).build();
        Mockito.when( cartValidations.weekendValidation() ).thenReturn(false);

        mockMvc.perform(post("/cart/buy").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cart))).andExpect(status().isOk());


    }

    @Test
    @DisplayName("It not should buy videogame")
    void shouldNotBuyVideogame() throws Exception {

        CommandVideogame videogame = new TestDataBuilderCommandVideogame().build();

        mockMvc.perform(post("/videogame").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videogame))).andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));

        List<CommandVideogamePurchase> videogames = new ArrayList<>();
        CommandVideogamePurchase videogame1 = new CommandVideogamePurchase(1, "League of legends", 2, 1, 150000);
        CommandVideogamePurchase videogame2 = new CommandVideogamePurchase(1, "God of war", 3, 1, 150000);
        videogames.add(videogame1);
        videogames.add(videogame2);

        CommandCart cart = new TestDataBuilderCommandCart().withVideogames(videogames).build();
        Mockito.when( cartValidations.weekendValidation() ).thenReturn(true);

        mockMvc.perform(post("/cart/buy").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cart))).andExpect(status().isInternalServerError());

    }

    @Test
    @DisplayName("It should calculate discount")
    void shouldCalculateDiscountMonday() throws Exception {
        CommandVideogame videogame = new TestDataBuilderCommandVideogame().build();

        mockMvc.perform(post("/videogame").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videogame))).andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));

        List<CommandVideogamePurchase> videogames = new ArrayList<>();
        CommandVideogamePurchase videogame1 = new CommandVideogamePurchase(1, "League of legends", 2, 1, 150000);
        CommandVideogamePurchase videogame2 = new CommandVideogamePurchase(1, "God of war", 3, 1, 150000);
        videogames.add(videogame1);
        videogames.add(videogame2);

        CommandCart cart = new TestDataBuilderCommandCart().withVideogames(videogames).build();
        Mockito.when( cartValidations.mondayValidation() ).thenReturn(true);

        mockMvc.perform(post("/cart/calculateDiscount").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cart))).andExpect(status().isOk())
                .andExpect(jsonPath("$.total", is(240000.0)));
    }

    @Test
    @DisplayName("It not should calculate discount")
    void shouldNotCalculateDiscountMonday() throws Exception {
        CommandVideogame videogame = new TestDataBuilderCommandVideogame().build();

        mockMvc.perform(post("/videogame").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(videogame))).andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));

        List<CommandVideogamePurchase> videogames = new ArrayList<>();
        CommandVideogamePurchase videogame1 = new CommandVideogamePurchase(1, "League of legends", 2, 1, 150000);
        CommandVideogamePurchase videogame2 = new CommandVideogamePurchase(1, "God of war", 3, 1, 150000);
        videogames.add(videogame1);
        videogames.add(videogame2);

        CommandCart cart = new TestDataBuilderCommandCart().withVideogames(videogames).build();
        Mockito.when( cartValidations.mondayValidation() ).thenReturn(false);

        mockMvc.perform(post("/cart/calculateDiscount").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cart))).andExpect(status().isOk())
                .andExpect(jsonPath("$.total", is(300000.0)));
    }


}

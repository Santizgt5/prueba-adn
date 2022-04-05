package com.ceiba.cart.entity;

import com.ceiba.BasePrueba;
import com.ceiba.cart.model.entity.Cart;
import com.ceiba.cart.service.testdatabuilder.CartTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.videogamepurchase.model.entity.VideogamePurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCart {

    @Test
    @DisplayName("It should successfully create the cart")
    void shouldCreateSuccesfullCart() {

        List<VideogamePurchase> videogamePurchases = new ArrayList<>();
        VideogamePurchase videogamePurchase = new VideogamePurchase(1, "Halo", 1, 150000);
        videogamePurchases.add(videogamePurchase);

        Cart cart = new Cart(1, 150000, 1, videogamePurchases);

        assertEquals(1, cart.getId());
        assertEquals(150000, cart.getTotal());
        assertEquals(1, cart.getTotalQuantity());
        assertEquals(videogamePurchases, cart.getVideogames());

    }

    @Test
    void shouldFailWithoutTotal() {

        CartTestDataBuilder cartTestDataBuilder = new CartTestDataBuilder().withTotal(0).withId(1);

        BasePrueba.assertThrows(() -> {
            cartTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Total must entered");

    }

    @Test
    void shouldFailWithoutTotalQuantity() {

        CartTestDataBuilder cartTestDataBuilder = new CartTestDataBuilder().witTotalQuantity(0).withId(1);

        BasePrueba.assertThrows(() -> {
            cartTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Total quantity must entered");

    }

    @Test
    void shouldFailWithoutVideogames() {

        CartTestDataBuilder cartTestDataBuilder = new CartTestDataBuilder().withVideogame(null).withId(1);

        BasePrueba.assertThrows(() -> {
            cartTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Videogames must entered");

    }








}

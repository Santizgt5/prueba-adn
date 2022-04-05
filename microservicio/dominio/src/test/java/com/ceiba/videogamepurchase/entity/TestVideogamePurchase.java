package com.ceiba.videogamepurchase.entity;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.videogamepurchase.model.entity.VideogamePurchase;
import com.ceiba.videogamepurchase.service.testdatabuilder.VideogamePurchaseTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVideogamePurchase {

    @Test
    @DisplayName("It should successfully create videogame purchase")
    void shouldCreateSuccesfullVideogamePurchase() {

        VideogamePurchase videogamePurchase = new VideogamePurchaseTestDataBuilder().withId(1).build();

        assertEquals(1, videogamePurchase.getId());
        assertEquals("Halo", videogamePurchase.getVideogame());
        assertEquals(1, videogamePurchase.getQuantity());
        assertEquals(150000, videogamePurchase.getPrice());

    }

    @Test
    void shoulFailWithoutVideogame() {

        VideogamePurchaseTestDataBuilder videogamePurchaseTestDataBuilder = new VideogamePurchaseTestDataBuilder().withVideogame(null).withId(1);

        BasePrueba.assertThrows(() -> {
            videogamePurchaseTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Videogame must entered");

    }

    @Test
    void shoulFailWithoutQuantity() {

        VideogamePurchaseTestDataBuilder videogamePurchaseTestDataBuilder = new VideogamePurchaseTestDataBuilder().withQuantity(0).withId(1);

        BasePrueba.assertThrows(() -> {
            videogamePurchaseTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Quantity must entered");

    }

    @Test
    void shoulFailWithoutPrice() {

        VideogamePurchaseTestDataBuilder videogamePurchaseTestDataBuilder = new VideogamePurchaseTestDataBuilder().withPrice(0).withId(1);

        BasePrueba.assertThrows(() -> {
            videogamePurchaseTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Price must entered");

    }

}

package com.ceiba.cart.service;

import com.ceiba.cart.CartValidations;
import com.ceiba.cart.model.dto.DtoCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class TestCalculateQuantityDiscountService {

    @InjectMocks
    private CalcuateQuantityDiscountService calcuateQuantityDiscountService;
    @Mock
    private CartValidations cartValidations;


    @Test
    @DisplayName("It should calcualte new price without discount")
    void shouldCalculateNewPriceWithOutDiscount() {
            DtoCart dtoCart = DtoCart.builder().cantidadTotal(2).total(300000).build();
            Mockito.when(cartValidations.mondayValidation()).thenReturn(false);
            calcuateQuantityDiscountService.ejecutar(dtoCart);

            assertEquals(300000, dtoCart.getTotal());

    }

    @Test
    @DisplayName("It should calcualte new price with one game")
    void shouldCalculateNewPriceWithOneGame() {
        DtoCart dtoCart = DtoCart.builder().cantidadTotal(1).total(150000).build();
        Mockito.when(cartValidations.mondayValidation()).thenReturn(true);
        calcuateQuantityDiscountService.ejecutar(dtoCart);

        assertEquals(150000, dtoCart.getTotal());

    }

    @Test
    @DisplayName("It should calcualte new price with discount")
    void shouldCalculateNewPriceWithDiscount() {
        DtoCart dtoCart = DtoCart.builder().cantidadTotal(2).total(300000).build();
        Mockito.when(cartValidations.mondayValidation()).thenReturn(true);
        calcuateQuantityDiscountService.ejecutar(dtoCart);

        assertEquals(240000, dtoCart.getTotal());

    }

}

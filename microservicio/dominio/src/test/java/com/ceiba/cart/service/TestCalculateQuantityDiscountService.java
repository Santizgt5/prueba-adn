package com.ceiba.cart.service;

import com.ceiba.cart.model.dto.DtoCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class TestCalculateQuantityDiscountService {

    @InjectMocks
    private CalcuateQuantityDiscountService calcuateQuantityDiscountService;

    @Test
    @DisplayName("It should previous validation to the company")
    void shouldCalculateNewPriceWithDiscount() {
            DtoCart dtoCart = DtoCart.builder().cantidadTotal(2).total(300000).build();
            calcuateQuantityDiscountService.ejecutar(dtoCart);

            assertEquals(300000, dtoCart.getTotal());


    }

}

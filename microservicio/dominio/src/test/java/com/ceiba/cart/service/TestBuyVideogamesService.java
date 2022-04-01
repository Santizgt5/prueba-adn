package com.ceiba.cart.service;

import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.videogame.model.dto.DtoVideogame;;
import com.ceiba.videogame.port.repository.VideogameRepository;
import com.ceiba.videogamePurchase.model.dto.DtoVideogamePurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class TestBuyVideogamesService {

    @InjectMocks
    private BuyVideogamesService buyVideogamesService;
    @Mock
    private VideogameRepository videogameRepository;

    @Test
    @DisplayName("It should previous validation to the company")
    void shouldBuyVideogame() {
        List<DtoVideogamePurchase> list = new ArrayList<>();
        DtoVideogame videogame = DtoVideogame.builder().id(1).title("God of war").companyId(2).releaseDate(LocalDate.now()).platform("PS5").price(150000).build();

        DtoVideogamePurchase videogamePurchase = DtoVideogamePurchase.builder().videogameId(1).videogame("God of war").price(135000).build();
        list.add(videogamePurchase);

        DtoCart cart = new DtoCart(1, 300000, 2, list);

        Mockito.when(videogameRepository.getVideogameById(Mockito.anyInt())).thenReturn(videogame);
        buyVideogamesService.ejecutar(cart);

        Mockito.verify(videogameRepository, Mockito.times(1)).actualizar(videogame);

    }



}
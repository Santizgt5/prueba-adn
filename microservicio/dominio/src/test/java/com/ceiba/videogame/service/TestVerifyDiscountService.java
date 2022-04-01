package com.ceiba.videogame.service;


import com.ceiba.company.model.entity.Company;
import com.ceiba.company.service.UpdateCompanyService;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.dao.DaoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class TestVerifyDiscountService {

    @InjectMocks
    private VerifyDiscountService verifyDiscountService;
    @Mock
    private DaoVideogame daoVideogame;

    @Test
    @DisplayName("It should verify succefull the list")
    void shouldVerifySuccefullVideogames() {
        Company company = new Company(1, "Bungie", "Test", LocalDate.now(), "1234");
        DtoVideogame videogame1 = DtoVideogame.builder().id(1).title("God of war").companyId(2).releaseDate(LocalDate.now()).platform("PS5").price(150000).build();
        DtoVideogame videogame2 = DtoVideogame.builder().id(2).title("Destiny").companyId(2).releaseDate(LocalDate.of(2021, 1, 13)).platform("PC").price(150000).build();
        List<DtoVideogame> list = new ArrayList<>();
        list.add(videogame1);
        list.add(videogame2);
        Mockito.when(daoVideogame.listar()).thenReturn(list);

        List<DtoVideogame> listModify = verifyDiscountService.ejecutar();

        assertEquals(135000, listModify.get(0).getPriceWithDiscountMonth());
        assertEquals(0, listModify.get(1).getPriceWithDiscountMonth());

    }


}

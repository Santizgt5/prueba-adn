package com.ceiba.cart.model.dto;

import com.ceiba.videogamepurchase.model.dto.DtoVideogamePurchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DtoCart {

    private int id;
    private double total;
    private int cantidadTotal;
    private List<DtoVideogamePurchase> videogames;


}

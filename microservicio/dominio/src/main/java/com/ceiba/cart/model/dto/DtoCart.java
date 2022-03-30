package com.ceiba.cart.model.dto;

import com.ceiba.cart.model.entity.VideogamePurchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class DtoCart {

    private int id;
    private double total;
    private List<Integer> videogames;


}

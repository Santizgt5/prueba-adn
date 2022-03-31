package com.ceiba.videogamePurchase.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DtoVideogamePurchase {

    private int id;
    private String videogame;
    private int videogameId;
    private int quantity;
    private double price;
    private double priceWithDiscount;


}

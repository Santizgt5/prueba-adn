package com.ceiba.videogamepurchase.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandVideogamePurchase {

    private int id;
    private String videogame;
    private int videogameId;
    private int quantity;
    private double price;

}

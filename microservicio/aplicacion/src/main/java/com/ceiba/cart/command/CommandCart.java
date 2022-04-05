package com.ceiba.cart.command;

import com.ceiba.videogamepurchase.command.CommandVideogamePurchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandCart {

    private int id;
    private double total;
    private  int cantidadTotal;
    private List<CommandVideogamePurchase> videogames;


}

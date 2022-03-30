package com.ceiba.cart.command;

import com.ceiba.cart.model.entity.VideogamePurchase;
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
    private List<Integer> videogames;


}

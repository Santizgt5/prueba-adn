package com.ceiba.cart.model.entity;

import com.ceiba.videogamepurchase.model.entity.VideogamePurchase;
import lombok.Getter;

import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Cart {

    public  static final  double DISCOUNT_MONDAY = 0.20;
    private static final String TOTAL_MUST_BE_ENTERED = "Total must entered";
    private static final String TOTAL_QUANTITY_MUST_BE_ENTERED = "Total quantity must entered";
    private static final String VIDEOGAMES_MUST_BE_ENTERED = "Videogames must entered";

    private int id;
    private double total;
    private int totalQuantity;
    private List<VideogamePurchase> videogames;

    public Cart(int id, double total, int totalQuantity, List<VideogamePurchase> videogames ) {
        validarObligatorioDouble(total, TOTAL_MUST_BE_ENTERED);
        validarObligatorioInteger(totalQuantity, TOTAL_QUANTITY_MUST_BE_ENTERED);
        validarObligatorio(videogames, VIDEOGAMES_MUST_BE_ENTERED);

        this.id = id;
        this.total = total;
        this.videogames = videogames;
        this.totalQuantity = totalQuantity;
    }
}

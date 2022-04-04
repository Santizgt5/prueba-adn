package com.ceiba.cart;

import java.util.Calendar;

public class CartValidations {

    public CartValidations() {
    }

    public boolean weekendValidation() {
        Calendar today = Calendar.getInstance();
        int day = today.get(Calendar.DAY_OF_WEEK);
        if(day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

    public boolean mondayValidation() {
        Calendar today = Calendar.getInstance();
        int day = today.get(Calendar.DAY_OF_WEEK);
        if(day == Calendar.MONDAY) {
            return  true;
        } else {
            return false;
        }
    }

}

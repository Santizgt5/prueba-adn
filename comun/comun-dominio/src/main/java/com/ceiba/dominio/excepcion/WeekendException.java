package com.ceiba.dominio.excepcion;

public class WeekendException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WeekendException(String message) {
        super(message);
    }
}

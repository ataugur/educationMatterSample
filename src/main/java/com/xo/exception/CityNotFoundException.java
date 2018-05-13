package com.xo.exception;

public class CityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3384677843219185167L;

    private static final String MESSAGE = "city not found with code ";

    public CityNotFoundException(String code) {
        super(MESSAGE + code);
    }
}

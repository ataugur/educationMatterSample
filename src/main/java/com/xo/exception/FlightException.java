package com.xo.exception;

public class FlightException extends RuntimeException {

    private static final long serialVersionUID = -93439843219185167L;

    public FlightException(String message) {
        super(message);
    }
}

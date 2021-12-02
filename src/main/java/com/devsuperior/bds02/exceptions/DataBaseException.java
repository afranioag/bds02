package com.devsuperior.bds02.exceptions;


public class DataBaseException extends RuntimeException{
    private static final long seriaLVersionUID = 1L;

    public DataBaseException(String message){
        super(message);
    }
}

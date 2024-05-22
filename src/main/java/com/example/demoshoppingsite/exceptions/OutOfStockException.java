package com.example.demoshoppingsite.exceptions;

public class OutOfStockException extends Exception{

    public OutOfStockException(String message){
        super(message);
    }

    public OutOfStockException(){

    }
}

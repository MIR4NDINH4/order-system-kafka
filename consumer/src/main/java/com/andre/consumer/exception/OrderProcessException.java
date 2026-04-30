package com.andre.consumer.exception;

public class OrderProcessException extends OrderException {

    public OrderProcessException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
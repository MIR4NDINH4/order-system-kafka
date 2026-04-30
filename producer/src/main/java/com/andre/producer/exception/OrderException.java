package com.andre.producer.exception;

public class OrderException extends RuntimeException {

    public OrderException(String mensagem) {
        super(mensagem);
    }

    public OrderException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
package com.andre.producer.exception;

public class OrderSendException extends OrderException {

    public OrderSendException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
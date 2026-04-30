package com.andre.consumer.exception;

public class OrderNotFoundException extends OrderException {

    public OrderNotFoundException(Long id) {
        super("Pedido não encontrado com o id: " + id);
    }
}
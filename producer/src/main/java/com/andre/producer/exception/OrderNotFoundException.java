package com.andre.producer.exception;

public class OrderNotFoundException extends OrderException {

    public OrderNotFoundException(Long id) {
        super("Pedido não encontrado com o id: " + id);
    }
}
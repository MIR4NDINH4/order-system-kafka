package com.andre.producer.service;

import com.andre.producer.exception.OrderSendException;
import com.andre.producer.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarPedido(Order pedido) {
        try {
            kafkaTemplate.send("pedidos", pedido.toString());
            System.out.println("Pedido enviado: " + pedido);
        } catch (Exception e) {
            throw new OrderSendException("Erro ao enviar pedido ao Kafka", e);
        }
    }
}
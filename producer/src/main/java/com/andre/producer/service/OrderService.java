package com.andre.producer.service;

import com.andre.producer.exception.OrderSendException;
import com.andre.producer.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void enviarPedido(Order pedido) {
        try {
            String json = objectMapper.writeValueAsString(pedido);
            kafkaTemplate.send("pedidos", json);
            System.out.println("Pedido enviado: " + json);
        } catch (Exception e) {
            throw new OrderSendException("Erro ao enviar pedido ao Kafka", e);
        }
    }
}
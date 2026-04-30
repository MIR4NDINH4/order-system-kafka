package com.andre.consumer.service;

import com.andre.consumer.exception.OrderProcessException;
import com.andre.consumer.model.Order;
import com.andre.consumer.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "pedidos", groupId = "grupo-processamento")
    public void receberPedido(String mensagem) {
        try {
            Order order = objectMapper.readValue(mensagem, Order.class);
            orderRepository.save(order);
            System.out.println("Pedido salvo no banco: " + order);
        } catch (Exception e) {
            throw new OrderProcessException("Erro ao processar pedido", e);
        }
    }
}
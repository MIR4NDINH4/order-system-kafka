package com.andre.consumer.service;

import com.andre.consumer.exception.OrderProcessException;
import com.andre.consumer.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @KafkaListener(topics = "pedidos", groupId = "grupo-processamento")
    public void receberPedido(String mensagem) {
        try {
            System.out.println("Pedido recebido: " + mensagem);
            // aqui futuramente podemos salvar no banco de dados
        } catch (Exception e) {
            throw new OrderProcessException("Erro ao processar pedido", e);
        }
    }
}
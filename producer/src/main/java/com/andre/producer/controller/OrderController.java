package com.andre.producer.controller;

import com.andre.producer.model.Order;
import com.andre.producer.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> enviarPedido(@RequestBody Order pedido) {
        orderService.enviarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido enviado com sucesso!");
    }
}
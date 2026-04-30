# Order System Kafka

Sistema de pedidos em tempo real utilizando Java, Spring Boot, Apache Kafka e Docker.

## Sobre o projeto

Este projeto simula um sistema de pedidos onde:
- O **Producer** expõe uma API REST para receber pedidos
- O **Kafka** atua como mensageria, distribuindo os pedidos
- O **Consumer** escuta o Kafka e processa os pedidos em tempo real

## Tecnologias

- Java 17
- Spring Boot 3.2
- Spring Kafka
- Apache Kafka
- Zookeeper
- Docker
- Docker Compose
- Lombok
- Maven

## Arquitetura
Producer (API REST) → Kafka (Tópico: pedidos) → Consumer (Listener)

## Como rodar o projeto

### Pré-requisitos
- Docker Desktop instalado e rodando

### Subindo o projeto

```bash
docker compose up --build
```

### Enviando um pedido

```bash
POST http://localhost:8081/pedidos
Content-Type: application/json

{
    "id": 1,
    "produto": "Pizza",
    "quantidade": 2
}
```

### Resposta esperada
Pedido enviado com sucesso!

Os logs do consumer vão exibir:
Pedido recebido: Order(id=1, produto=Pizza, quantidade=2)

## Estrutura do projeto

```
order-system-kafka/
├── docker-compose.yml
├── producer/
│   ├── Dockerfile
│   └── src/main/java/com/andre/producer/
│       ├── controller/
│       │   └── OrderController.java
│       ├── service/
│       │   └── OrderService.java
│       ├── model/
│       │   └── Order.java
│       └── exception/
│           ├── GlobalExceptionHandler.java
│           ├── OrderException.java
│           ├── OrderNotFoundException.java
│           └── OrderSendException.java
└── consumer/
    ├── Dockerfile
    └── src/main/java/com/andre/consumer/
        ├── service/
        │   └── OrderService.java
        ├── model/
        │   └── Order.java
        └── exception/
            ├── GlobalExceptionHandler.java
            ├── OrderException.java
            └── OrderProcessException.java
```

## Autor

André — [github.com/MIR4NDINH4](https://github.com/MIR4NDINH4)
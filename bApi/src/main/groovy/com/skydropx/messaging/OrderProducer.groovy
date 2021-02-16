package com.skydropx.messaging

import com.skydropx.domain.Order
import io.micronaut.rabbitmq.annotation.RabbitClient
import io.micronaut.rabbitmq.annotation.Binding

@RabbitClient("skydropx.demo")
interface OrderProducer {
    @Binding(value = "order")
    void send(Order order)
}
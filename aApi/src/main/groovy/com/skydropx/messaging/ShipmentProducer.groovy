package com.skydropx.messaging

import com.skydropx.domain.Shipment
import io.micronaut.rabbitmq.annotation.RabbitClient
import io.micronaut.rabbitmq.annotation.Binding

@RabbitClient("skydropx.demo")
interface ShipmentProducer {
    @Binding("shipment")
    void send(Shipment shipment)
}
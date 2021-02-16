package com.skydropx.messaging


import com.skydropx.domain.Shipment
import com.skydropx.services.imp.OrderServiceImp
import io.micronaut.rabbitmq.annotation.RabbitListener
import io.micronaut.rabbitmq.annotation.Queue
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Inject

@RabbitListener
class ShipmentConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(ShipmentConsumer.class)

    @Queue("shipment-queue")
    void receive(Shipment shipment) {
        LOG.info("Shipment message received!")
        LOG.info("Updating order $shipment.orderId shipment status...")
        LOG.info("Order shipment status updated!")
    }
}
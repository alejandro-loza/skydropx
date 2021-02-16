package com.skydropx.messaging

import com.skydropx.domain.Order
import com.skydropx.domain.Shipment
import com.skydropx.services.ShippingService
import io.micronaut.rabbitmq.annotation.RabbitListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import io.micronaut.rabbitmq.annotation.Queue

@RabbitListener
class OrderConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(OrderConsumer.class)
    private final ShippingService shippingService

    OrderConsumer(ShippingService shippingService) {
        this.shippingService = shippingService
    }

    @Queue("order-queue")
    Shipment receive(Order order) throws InterruptedException {
        LOG.info("Order with traking number id $order.trackingNumber and Carrier $order.carrier received!")
        LOG.info("Creating shipment...")
        /* shipping is slow! */
        Thread.sleep(15*1000)
        return shippingService.newShipment(order)
    }
}
package com.skydropx.messaging

import com.skydropx.domain.Order
import com.skydropx.domain.Shipment
import com.skydropx.domain.ShipmentStatus
import com.skydropx.services.OrderService
import io.micronaut.rabbitmq.annotation.RabbitListener
import io.micronaut.rabbitmq.annotation.Queue
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Inject

@RabbitListener
class ShipmentConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(ShipmentConsumer.class)

    @Inject
    OrderService orderService

    @Queue("shipment-queue")
    void receive(Shipment shipment) {
        LOG.info("Shipment message received!")
        LOG.info("Updating order $shipment.orderId shipment status...")
      /*  Order order = orderService.getOrderById(shipment.orderId)
        LOG.info("Order to update $order.id ")

        order.shipmentStatus = ShipmentStatus.SHIPPED
        orderService.updateOrder(order)*/
        LOG.info("Order shipment status updated!")
    }
}
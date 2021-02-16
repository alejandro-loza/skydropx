package com.skydropx.services.imp

import com.skydropx.dtos.FedexShippmentDto
import com.skydropx.dtos.OrderCreateCommand
import com.skydropx.messaging.OrderProducer
import com.skydropx.domain.Order
import com.skydropx.services.FedexService
import com.skydropx.services.OrderService

import javax.inject.Inject

class OrderServiceImp implements OrderService {

    @Inject
    OrderProducer orderProducer

    @Inject
    FedexService fedexService

    public List<Order> orders = new ArrayList<>()

    @Override
    List<FedexShippmentDto> listFedexOrders() {
        return fedexService.getShipments()
    }

    @Override
    void sendFedexOrders() {
        fedexService.getShipments().each {FedexShippmentDto dto ->
            Order order = new Order()
            order.with {
                order.id = dto.tracking_number as Long
                trackingNumber = dto.tracking_number
                carrier = dto.carrier
            }
            orderProducer.send(order)
        }
    }

    @Override
    Order newOrder(OrderCreateCommand cmd) {
        Order order = new Order()
        order.with {
            order.id = (long) orders.size() + 1
            trackingNumber = cmd.trackingNumber
            carrier = cmd.carrier
        }
        this.orders.add(order)
        orderProducer.send(order)
        return order
    }
}
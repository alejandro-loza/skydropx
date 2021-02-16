package com.skydropx.services

import com.skydropx.dtos.OrderCreateCommand
import com.skydropx.messaging.OrderProducer
import com.skydropx.domain.Order

import javax.inject.Inject

class OrderService {

    @Inject
    OrderProducer orderProducer

    public List<Order> orders = new ArrayList<>()


    Order getOrderById(Long id) {
        return orders.stream().filter(it -> it.id.equals(id)).findFirst().orElse(null)
    }

    List<Order> listOrders() {
        return orders
    }

    void updateOrder(Order order) {
        Order existingOrder = getOrderById(order.id as Integer)
        int i = orders.indexOf(existingOrder)
        orders.set(i, order)
    }

    Order newOrder(OrderCreateCommand cmd) {
        Order order = new Order()
        order.with {
            order.id = (long) orders.size() + 1
            totalCost = cmd.totalCost

        }
        this.orders.add(order)
        orderProducer.send(order)
        return order
    }
}
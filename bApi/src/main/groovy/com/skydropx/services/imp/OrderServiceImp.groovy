package com.skydropx.services.imp

import com.skydropx.dtos.OrderCreateCommand
import com.skydropx.messaging.OrderProducer
import com.skydropx.domain.Order
import com.skydropx.services.OrderService

import javax.inject.Inject

class OrderServiceImp implements OrderService {

    @Inject
    OrderProducer orderProducer

    public List<Order> orders = new ArrayList<>()

    @Override
    Order getOrderById(Long id) {
        return orders.stream().filter(it -> it.id.equals(id)).findFirst().orElse(null)
    }

    @Override
    List<Order> listOrders() {
        return orders
    }

    @Override
    void updateOrder(Order order) {
        Order existingOrder = getOrderById(order.id as Integer)
        int i = orders.indexOf(existingOrder)
        orders.set(i, order)
    }

    @Override
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
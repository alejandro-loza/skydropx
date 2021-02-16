package com.skydropx.services

import com.skydropx.domain.Order
import com.skydropx.dtos.OrderCreateCommand

interface OrderService {
    Order getOrderById(Long id)
    List<Order> listOrders()
    void updateOrder(Order order)
    Order newOrder(OrderCreateCommand cmd)
}
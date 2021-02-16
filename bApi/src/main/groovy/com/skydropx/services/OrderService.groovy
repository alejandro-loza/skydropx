package com.skydropx.services

import com.skydropx.domain.Order
import com.skydropx.dtos.OrderCreateCommand

interface OrderService {
    List<Order> listFedexOrders()
    void sendFedexOrders()
    Order newOrder(OrderCreateCommand cmd)
}
package com.skydropx.controller

import com.skydropx.domain.Order
import com.skydropx.dtos.OrderCreateCommand
import com.skydropx.services.OrderService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated

import javax.inject.Inject

@Controller("/order")
@Validated
class OrderController {
    @Inject
    OrderService orderService

    @Get("/fedex")
    HttpResponse<List<Order>> listOrders() {
        return HttpResponse.ok(orderService.listFedexOrders())
    }

    @Get("/fedex/send")
    HttpResponse<List<Order>> sendOrders() {
        return HttpResponse.ok(orderService.sendFedexOrders())
    }

    @Post("/")
    HttpResponse<Order> newOrder(@Body OrderCreateCommand order) {
        return HttpResponse.created(orderService.newOrder(order))
    }

}
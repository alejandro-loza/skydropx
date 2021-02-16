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

    @Get("/")
    HttpResponse<List<Order>> listOrders() {
        return HttpResponse.ok(
                orderService.listOrders()
        )
    }

    @Get("/{id}")
    HttpResponse getOrder(Long id) {
        Order order = orderService.getOrderById(id)
        if( order != null ) {
            return HttpResponse.ok(
                    order
            )
        }
        return HttpResponse.notFound()

    }

    @Post("/")
    HttpResponse<Order> newOrder(@Body OrderCreateCommand order) {
        return HttpResponse.created(orderService.newOrder(order))
    }

    @Put("/")
    HttpResponse updateOrder(@Body Order order) {
        orderService.updateOrder(order)
        return HttpResponse.ok()
    }
}
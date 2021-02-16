package com.skydropx.controllers

import com.skydropx.domain.Shipment
import com.skydropx.services.ShippingService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import io.micronaut.http.HttpResponse

import javax.inject.Inject
import java.util.stream.Collectors

@Controller("/shipping")
class ShippingController {

    @Inject
    ShippingService shippingService

    @Get(uri="/", produces="text/plain")
    String index() {
        return "Example Response"
    }

    @Get("/shipments/recent/{count}")
    HttpResponse<List<Shipment>> getRecentShipments(Long count) {
        return HttpResponse.ok(
                shippingService.listShipments().stream().limit(count).collect(Collectors.toList())
        )
    }
}
package com.skydropx.domain

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected

@Introspected
class Shipment {
    Long id
    Long orderId
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    Date shippedOn

    Shipment(Long id, Long orderId, Date shippedOn) {
        this.id = id
        this.orderId = orderId
        this.shippedOn = shippedOn
    }


}

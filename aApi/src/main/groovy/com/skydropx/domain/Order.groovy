package com.skydropx.domain

import io.micronaut.core.annotation.Introspected

@Introspected
class Order {

    Long id
    String carrier
    Long trackingNumber
    ShipmentStatus shipmentStatus

    Order(){}

    Order(String carrier, Long trackingNumber, ShipmentStatus shipmentStatus) {
        this.carrier = carrier
        this.trackingNumber = trackingNumber
        this.shipmentStatus = shipmentStatus != null ? shipmentStatus : ShipmentStatus.PENDING
    }
}

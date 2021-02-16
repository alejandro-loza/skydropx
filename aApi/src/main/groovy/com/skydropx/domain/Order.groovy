package com.skydropx.domain

import io.micronaut.core.annotation.Introspected;

@Introspected
class Order {

    Long id
    Integer customerId
    Double totalCost
    ShipmentStatus shipmentStatus

    Order(Long id, Integer customerId, Double totalCost, ShipmentStatus shipmentStatus) {
        this.id = id
        this.customerId = customerId
        this.totalCost = totalCost
        this.shipmentStatus = shipmentStatus != null ? shipmentStatus : ShipmentStatus.PENDING
    }
}

package com.skydropx.domain

import io.micronaut.core.annotation.Introspected;

@Introspected
class Order {

    Long id
    Long customerId
    Double totalCost
    ShipmentStatus shipmentStatus

    Order(){}

    Order(Integer customerId, Double totalCost, ShipmentStatus shipmentStatus) {
        this.customerId = customerId
        this.totalCost = totalCost
        this.shipmentStatus = shipmentStatus != null ? shipmentStatus : ShipmentStatus.PENDING
    }

    void setShipmentStatus(ShipmentStatus shipmentStatus) {
        this.shipmentStatus = shipmentStatus
    }
}

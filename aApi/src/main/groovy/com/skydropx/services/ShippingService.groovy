package com.skydropx.services

import com.skydropx.domain.Order
import com.skydropx.domain.Shipment
import com.skydropx.messaging.ShipmentProducer
import org.slf4j.LoggerFactory

import javax.inject.Inject
import org.slf4j.Logger

class ShippingService {
    private static final Logger LOG = LoggerFactory.getLogger(ShippingService.class)

    @Inject
    ShipmentProducer shipmentProducer

    private final List<Shipment> shipments = Collections.synchronizedList(new ArrayList<>())


    Shipment getShipmentById(Long id) {
        Shipment shipment
        synchronized (shipments) {
            shipment = shipments.stream().filter(it -> it.id.equals(id)).findFirst().orElse(null)
        }
        return shipment
    }

    List<Shipment> listShipments() {
        return shipments;
    }

    void updateShipment(Shipment shipment) {
        Shipment existingShipment = getShipmentById(shipment.id)
        synchronized (shipments) {
            int i = shipments.indexOf(existingShipment);
            shipments.set(i, shipment);
        }
    }

    Shipment newShipment(Order order) {
        Shipment shipment = new Shipment((long) shipments.size(), order.id, new Date())
        synchronized (shipments) {
            shipments.add(shipment)
        }
        LOG.info("Shipment created!")
        LOG.info("Sending shipment message with order id $order.id ...")
        shipmentProducer.send(shipment)
        LOG.info("Shipment message sent!")
        return shipment
    }

}
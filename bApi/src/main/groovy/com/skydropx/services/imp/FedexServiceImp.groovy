package com.skydropx.services.imp

import com.skydropx.clients.FedexFakeClient
import com.skydropx.dtos.FedexShippmentDto
import com.skydropx.services.FedexService

import javax.inject.Inject

class FedexServiceImp implements FedexService {
    @Inject
    FedexFakeClient fedexClient

    @Override
    List<FedexShippmentDto> getShipments(){
        return  fedexClient.getOrders()
    }
}

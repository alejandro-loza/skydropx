package com.skydropx.services

import com.skydropx.dtos.FedexShippmentDto

interface FedexService {
    List<FedexShippmentDto> getShipments()
}
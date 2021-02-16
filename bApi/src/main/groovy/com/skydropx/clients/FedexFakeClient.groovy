package com.skydropx.clients

import com.skydropx.dtos.FedexShippmentDto
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client(value = '${fedex.url}')
interface FedexFakeClient {
    @Get("/data")
    List<FedexShippmentDto> getOrders()
}
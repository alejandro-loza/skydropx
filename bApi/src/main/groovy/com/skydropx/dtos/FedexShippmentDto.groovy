package com.skydropx.dtos

import io.micronaut.core.annotation.Introspected

@Introspected
class FedexShippmentDto {
    String tracking_number
    String carrier
}

package com.skydropx.dtos

import com.skydropx.domain.ShipmentStatus
import groovy.transform.CompileStatic
import groovy.transform.ToString
import io.micronaut.core.annotation.Introspected

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
@CompileStatic
@ToString(includeNames = true, includePackage = false)
class OrderCreateCommand {

    @NotNull()
    Long customerId

    @NotNull()
    Double totalCost

    @NotNull()
    @NotBlank()
    ShipmentStatus shipmentStatus
}

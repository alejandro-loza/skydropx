package com.skydropx.controller

import com.skydropx.Application
import com.skydropx.domain.Order
import com.skydropx.domain.ShipmentStatus
import io.micronaut.context.annotation.Property
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxStreamingHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

@Property(name = 'spec.name', value = 'order controller')
@MicronautTest(application = Application.class)
class OrderControllerSpec extends Specification{
    public static final String ORDER_ROOT = "/order"


    @Shared
    @Inject
    @Client("/")
    RxStreamingHttpClient client


    def "Should create order"(){
        given:
        Order order = new Order( 666, 1.55, "SHIPPED" as ShipmentStatus)

        HttpRequest request = HttpRequest.POST(ORDER_ROOT, order)

        when:
        def rsp = client.toBlocking().exchange(request, Map)

        then:
        assert rsp
        assert rsp.status == HttpStatus.CREATED
    }

}

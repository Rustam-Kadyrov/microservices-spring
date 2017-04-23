package org.test.microservices.dispatcher.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.microservices.dispatcher.model.CreateCustomerEvent;
import org.test.microservices.dispatcher.model.CreateOrderEvent;
import org.test.microservices.dispatcher.service.EventService;

/**
 * Created by Rustam_Kadyrov on 25.04.2017.
 */
@RestController
public class DispatcherEndpoint {

    @Autowired
    private EventService eventService;

    @PostMapping("createOrder")
    public ResponseEntity createOrder(@RequestBody CreateOrderEvent event) {
        eventService.createOrderEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("createCustomer")
    public ResponseEntity createCustomer(@RequestBody CreateCustomerEvent event) {
        eventService.createCustomerEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

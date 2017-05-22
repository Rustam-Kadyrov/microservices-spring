package com.poc.microservices.customer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.microservices.customer.model.Customer;
import com.poc.microservices.dispatcher.model.CreateCustomerEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Rustam_Kadyrov on 20.05.2017.
 */
@Component
@Slf4j
public class QueueListener {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "customer-command-queue")
    public void customerWorker(Message message) {
        try {
            log.info("customerWorker; accepted message: {}", message);
            Customer saved = customerService.save(toCustomer(message));
            log.debug("customerWorker; saved value: {}", saved);
        } catch (Exception e) {
            log.error("{}", e);
        }
    }

    private Customer toCustomer(Message message) throws IOException {
        CreateCustomerEvent customerEvent = objectMapper.readValue(message.getBody(), CreateCustomerEvent.class);
        return Customer.builder()
                .name(customerEvent.getName())
                .build();
    }
}

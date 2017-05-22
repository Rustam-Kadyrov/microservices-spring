package com.poc.microservices.dispatcher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.microservices.dispatcher.model.CreateCustomerEvent;
import com.poc.microservices.dispatcher.model.CreateOrderEvent;
import com.poc.microservices.dispatcher.model.Event;
import com.poc.microservices.dispatcher.repository.CreateCustomerEventRepository;
import com.poc.microservices.dispatcher.repository.CreateOrderEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Rustam_Kadyrov on 19.05.2017.
 */
@Service
@Slf4j
@Transactional
public class EventService {

    @Autowired
    private CreateCustomerEventRepository createCustomerEventRepository;

    @Autowired
    private CreateOrderEventRepository createOrderEventRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void createCustomerEvent(CreateCustomerEvent event) {
        CreateCustomerEvent created = createCustomerEventRepository.save(event);
        log.debug("createCustomerEvent; created: {}", created);
        sendEventToQueue("customer", created);
    }

    public void createOrderEvent(CreateOrderEvent event) {
        CreateOrderEvent created = createOrderEventRepository.save(event);
        log.debug("createOrderEvent; created: {}", created);
        sendEventToQueue("order", created);
    }

    private void sendEventToQueue(String routingKey, Event event) {
        rabbitTemplate.convertAndSend(routingKey, event);
    }
}

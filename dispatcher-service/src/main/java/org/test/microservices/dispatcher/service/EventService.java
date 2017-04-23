package org.test.microservices.dispatcher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.microservices.dispatcher.model.CreateCustomerEvent;
import org.test.microservices.dispatcher.model.CreateOrderEvent;
import org.test.microservices.dispatcher.model.Event;
import org.test.microservices.dispatcher.repository.CreateCustomerEventRepository;
import org.test.microservices.dispatcher.repository.CreateOrderEventRepository;

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

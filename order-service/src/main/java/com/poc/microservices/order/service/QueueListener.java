package com.poc.microservices.order.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.microservices.dispatcher.model.CreateOrderEvent;
import com.poc.microservices.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by Rustam_Kadyrov on 20.05.2017.
 */
@Component
@Slf4j
public class QueueListener {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "order-command-queue")
    public void orderWorker(Message message) throws IOException {
        try {
            log.info("orderWorker; accepted message: {}", message);
            CreateOrderEvent orderEvent = objectMapper.readValue(message.getBody(), CreateOrderEvent.class);
            Order.OrderBuilder orderBuilder = Order.builder()
                    .id(UUID.randomUUID().toString())
                    .number(orderEvent.getNumber())
                    .date(orderEvent.getDate().toInstant().toEpochMilli());
            Order saved = orderService.save(orderBuilder, orderEvent.getCustomerName());
            log.debug("orderWorker; saved value: {}", saved);
        } catch (Exception e) {
            log.error("{}", e);
        }
    }

}

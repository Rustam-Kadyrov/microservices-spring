package org.test.microservices.order.service;

import com.test.microservices.customer.client.CustomerClient;
import com.test.microservices.customer.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.microservices.order.model.Order;
import org.test.microservices.order.repository.OrderRepository;

import java.util.List;

/**
 * Created by Rustam_Kadyrov on 25.04.2017.
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private CustomerClient customerClient;

    public Order findOne(String id) {
        return repository.findOne(id);
    }

    public Order save(Order.OrderBuilder orderBuilder, String customerName) {
        log.info("save;");
        CustomerDto customerDto = getCustomerByName(customerName);
        orderBuilder.customerId(customerDto.getId());
        Order order = orderBuilder.build();
        log.info("save; order: {}", order);
        return repository.save(order);
    }

    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    public List<Order> reportCustomer(String name) {
        CustomerDto customerDto = getCustomerByName(name);
        return repository.findByCustomerId(customerDto.getId());
    }

    private CustomerDto getCustomerByName(String name) {
        CustomerDto customerDto = customerClient.findByName(name).getBody();
        if (customerDto == null) {
            throw new RuntimeException("Customer not found!");
        }
        return customerDto;
    }
}
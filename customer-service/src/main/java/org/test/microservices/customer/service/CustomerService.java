package org.test.microservices.customer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.microservices.customer.model.Customer;
import org.test.microservices.customer.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rustam_Kadyrov on 26.04.2017.
 */
@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll() {
        Iterator<Customer> i = repository.findAll().iterator();
        List<Customer> result = new ArrayList<Customer>();
        while (i.hasNext()) {
            result.add(i.next());
        }
        return result;
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Customer findOne(String id) {
        log.info("findOne; {}", id);
        return repository.findOne(id);
    }

    public Customer findByName(String name) {
        return repository.findByName(name);
    }
}

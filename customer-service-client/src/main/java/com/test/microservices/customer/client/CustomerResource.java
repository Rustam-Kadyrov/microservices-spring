package com.test.microservices.customer.client;

import com.test.microservices.customer.model.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Rustam_Kadyrov on 26.04.2017.
 */
public interface CustomerResource {

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    ResponseEntity<CustomerDto> findOne(@PathVariable("id") String id);

    @RequestMapping(value = "list", method = RequestMethod.GET)
    ResponseEntity<List<CustomerDto>> findAll();

    @RequestMapping(value = "findByName/{name}", method = RequestMethod.GET)
    ResponseEntity<CustomerDto> findByName(@PathVariable("name") String name);
}

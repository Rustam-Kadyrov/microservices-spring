package org.test.microservices.customer.endpoint;

import com.test.microservices.customer.client.CustomerResource;
import com.test.microservices.customer.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.test.microservices.customer.model.CustomerConverter;
import org.test.microservices.customer.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rustam_Kadyrov on 25.04.2017.
 */
@RestController
public class CustomerEndpoint implements CustomerResource {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerConverter customerConverter;

    public ResponseEntity<CustomerDto> findOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(customerConverter.doForward(service.findOne(id)));
    }

    public ResponseEntity<List<CustomerDto>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream()
                        .map(customer -> customerConverter.doForward(customer))
                        .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<CustomerDto> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(customerConverter.doForward(service.findByName(name)));
    }
}

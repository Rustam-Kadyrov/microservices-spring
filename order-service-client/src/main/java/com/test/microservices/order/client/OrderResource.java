package com.test.microservices.order.client;

import com.test.microservices.order.model.OrderDto;
import com.test.microservices.order.model.OrderReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Rustam_Kadyrov on 19.05.2017.
 */
public interface OrderResource {

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDto> findOne(@PathVariable("id") String id);

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> findAll();

    @RequestMapping(value = "report/{customerName}", method = RequestMethod.GET)
    public ResponseEntity<OrderReportDto> reportCustomer(@PathVariable("customerName") String customerName);
}

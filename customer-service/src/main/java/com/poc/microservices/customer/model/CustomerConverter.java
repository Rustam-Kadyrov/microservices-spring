package com.poc.microservices.customer.model;

import com.google.common.base.Converter;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;


/**
 * Created by Rustam_Kadyrov on 26.04.2017.
 */
@Component
public class CustomerConverter extends Converter<Customer, CustomerDto> {
    @Override
    public CustomerDto doForward(Customer customer) {
        if (isNull(customer)) {
            return null;
        }
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .payload(customer.getPayload()).build();
    }

    @Override
    public Customer doBackward(CustomerDto customerDto) {
        if (isNull(customerDto)) {
            return null;
        }
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .payload(customerDto.getPayload()).build();
    }
}

package org.test.microservices.order.model;

import com.google.common.base.Converter;
import com.test.microservices.order.model.OrderDto;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;

import static java.util.Objects.isNull;

/**
 * Created by Rustam_Kadyrov on 19.05.2017.
 */
@Component
public class OrderConverter extends Converter<Order, OrderDto> {
    @Override
    public OrderDto doForward(Order order) {
        if (isNull(order)) {
            return null;
        }
        return OrderDto.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .number(order.getNumber())
                .date(Instant.ofEpochMilli(order.getDate()).atZone(ZoneId.systemDefault()))
                .build();
    }

    @Override
    public Order doBackward(OrderDto orderDto) {
        if (isNull(orderDto)) {
            return null;
        }
        return Order.builder()
                .id(orderDto.getId())
                .customerId(orderDto.getCustomerId())
                .number(orderDto.getNumber())
                .date(orderDto.getDate().toInstant().toEpochMilli())
                .build();
    }
}

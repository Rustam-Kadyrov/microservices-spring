package com.test.microservices.order.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Created by Rustam_Kadyrov on 19.05.2017.
 */
@Getter
@Setter
@Builder
@ToString
public class OrderDto {
    private String id;
    private String customerId;
    private String number;
    private ZonedDateTime date;
}

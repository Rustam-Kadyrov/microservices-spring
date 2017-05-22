package com.poc.microservices.order.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Rustam_Kadyrov on 20.05.2017.
 */
@Getter
@Setter
@Builder
@ToString
public class OrderReportDto {
    private String customerName;
    private List<OrderDto> orders;
}

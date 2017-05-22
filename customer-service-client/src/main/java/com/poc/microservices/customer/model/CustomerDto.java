package com.poc.microservices.customer.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Rustam_Kadyrov on 26.04.2017.
 */
@Getter
@Setter
@Builder
@ToString
public class CustomerDto {
    private String id;
    private String name;
    private String payload;
}

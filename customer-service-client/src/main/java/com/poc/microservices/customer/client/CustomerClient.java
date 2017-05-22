package com.poc.microservices.customer.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import static com.poc.microservices.customer.client.CustomerClient.SERVICE_ID;

/**
 * Created by Rustam_Kadyrov on 26.04.2017.
 */
@FeignClient(SERVICE_ID)
public interface CustomerClient extends CustomerResource {
    String SERVICE_ID = "customer-service";
}

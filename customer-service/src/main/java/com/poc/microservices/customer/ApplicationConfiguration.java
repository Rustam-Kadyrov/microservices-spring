package com.poc.microservices.customer;

import com.poc.microservices.customer.client.CustomerClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Rustam_Kadyrov on 23.04.2017.
 */
@Configuration
@EnableFeignClients(basePackageClasses = CustomerClient.class)
@EnableJpaRepositories
public class ApplicationConfiguration {
}

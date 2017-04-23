package org.test.microservices;

import com.test.microservices.customer.client.CustomerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Rustam_Kadyrov on 23.04.2017.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = CustomerClient.class)
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}

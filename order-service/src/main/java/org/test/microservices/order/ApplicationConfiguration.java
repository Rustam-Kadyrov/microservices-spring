package org.test.microservices.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.test.microservices.order.repository.OrderRepository;

/**
 * Created by Rustam_Kadyrov on 23.04.2017.
 */
@Configuration
@EnableElasticsearchRepositories(basePackageClasses = OrderRepository.class)
public class ApplicationConfiguration {

    @Bean
    ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

}

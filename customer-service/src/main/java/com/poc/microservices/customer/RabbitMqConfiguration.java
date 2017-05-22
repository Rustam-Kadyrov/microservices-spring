package com.poc.microservices.customer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rustam_Kadyrov on 20.05.2017.
 */
@Configuration
public class RabbitMqConfiguration {


    @Value("${rabbitmq.username}")
    private String username;

    @Value("${rabbitmq.password}")
    private String password;

    @Value("${rabbitmq.queue.customer.name}")
    private String queueCustomerName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.addresses}")
    private String addresses;

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setUsername(username);
        factory.setPassword(password);
        factory.setAddresses(addresses);
        return factory;
    }

    @Bean
    RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setExchange(exchangeName);
        return rabbitTemplate;
    }

    @Bean
    Queue customerQueue() {
        return new Queue(queueCustomerName);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    Binding customerCommandBinding() {
        return BindingBuilder.bind(customerQueue()).to(directExchange()).with("customer");
    }

}

package org.test.microservices.order.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.test.microservices.order.model.Order;

import java.util.List;

/**
 * Created by Rustam_Kadyrov on 25.04.2017.
 */
public interface OrderRepository extends ElasticsearchRepository<Order, String> {

    List<Order> findByCustomerId(String customerId);
}

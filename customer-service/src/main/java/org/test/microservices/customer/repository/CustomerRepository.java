package org.test.microservices.customer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.test.microservices.customer.model.Customer;

/**
 * Created by Rustam_Kadyrov on 26.04.2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Query("select c from Customer c where c.name = :name")
    Customer findByName(@Param("name") String name);
}

package com.poc.microservices.dispatcher.repository;

import com.poc.microservices.dispatcher.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Rustam_Kadyrov on 19.05.2017.
 */
@NoRepositoryBean
public interface EventRepository<T extends Event> extends CrudRepository<T, String> {
}

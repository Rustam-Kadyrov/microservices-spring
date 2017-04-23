package org.test.microservices.dispatcher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.test.microservices.dispatcher.model.Event;

/**
 * Created by Rustam_Kadyrov on 19.05.2017.
 */
@NoRepositoryBean
public interface EventRepository<T extends Event> extends CrudRepository<T, String> {
}

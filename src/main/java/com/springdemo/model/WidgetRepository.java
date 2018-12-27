package com.springdemo.model;

import org.springframework.data.repository.CrudRepository;

/**
 * cf.
 * https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * 
 * This will be AUTO IMPLEMENTED by Spring into a Bean called widgetRepository
 * CRUD refers Create, Read, Update, Delete
 * 
 * @author Pierre
 *
 */
public interface WidgetRepository extends CrudRepository<Widget, Long> {

}

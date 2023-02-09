package com.order.app.business.abstracts;

import java.util.List;

/*
 * Generic BaseService interface
 * Defines CRUD operations and used as base for other services
 */
public interface BaseService<T> {

    List<T> getAll();

    T getById(int id);

    void add(T entity);

    void update(T entity);

    void delete(int id);
}

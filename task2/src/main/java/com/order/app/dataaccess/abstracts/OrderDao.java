package com.order.app.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.app.entities.concretes.Order;

/*
 * OrderDao interface
 * Keeps Order entity's sql queries and functions by using JpaRepository
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> getAllByPriceLessThan(double price);

    List<Order> getAllByPriceGreaterThan(double price);

    @Query("SELECT sum(o.price) from Order o where month(o.customer.registerDate) = ?1")
    double getSumByCustomer_RegisterDate(int month);

    @Query("SELECT o from Order o where month(o.customer.registerDate) = ?1")
    List<Order> getAllByCustomer_RegisterDate(int month);

    @Query("SELECT avg(o.price) from Order o where o.price > ?1")
    double getAverageByPriceGreaterThan(double price);

}

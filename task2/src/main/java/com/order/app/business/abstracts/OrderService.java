package com.order.app.business.abstracts;

import java.util.List;

import com.order.app.entities.concretes.Order;

/*
 * OrderService interface extends BaseService
 * Defines Order entity-specific functions
 */
public interface OrderService extends BaseService<Order> {

    List<Order> getAllByPriceLessThan(double price);

    List<Order> getAllByPriceMoreThan(double price);

    double getSumByCustomerRegisterDate(int month);

    List<Order> getAllByCustomerRegisterDate(int month);

    double getAverageByPriceGreaterThan(double price);

}

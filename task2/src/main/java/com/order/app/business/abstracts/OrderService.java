package com.order.app.business.abstracts;

import java.util.List;

import com.order.app.entities.concretes.Order;

public interface OrderService extends BaseService<Order> {

    List<Order> getAllByPriceLessThan(double price);

    List<Order> getAllByPriceMoreThan(double price);

}

package com.order.app.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.app.business.abstracts.OrderService;
import com.order.app.dataaccess.abstracts.OrderDao;
import com.order.app.entities.concretes.Order;

@Service
public class OrderManager implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public Order getById(int id) {
        Optional<Order> result = orderDao.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void add(Order order) {
        orderDao.save(order);
    }

    @Override
    public void update(Order order) {
        Optional<Order> result = orderDao.findById(order.getId());
        if (result.isPresent()) {
            orderDao.save(order);
        }
    }

    @Override
    public void delete(int id) {
        Optional<Order> result = orderDao.findById(id);
        if (result.isPresent()) {
            orderDao.delete(result.get());
        }
    }

    @Override
    public List<Order> getAllByPriceLessThan(double price) {
        return orderDao.getAllByPriceLessThan(price);
    }

    @Override
    public List<Order> getAllByPriceMoreThan(double price) {
        return orderDao.getAllByPriceGreaterThan(price);
    }

}

package com.order.app.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.app.business.abstracts.OrderService;
import com.order.app.dataaccess.abstracts.OrderDao;
import com.order.app.entities.concretes.Order;

/*
 * OrderManager class implements OrderService
 * Business class for Order Entity
 */
@Service
public class OrderManager implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /*
     * Return all orders
     */
    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    /*
     * Return one order according to given id
     */
    @Override
    public Order getById(int id) {
        Optional<Order> result = orderDao.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    /*
     * Add a new order
     */
    @Override
    public void add(Order order) {
        orderDao.save(order);
    }

    /*
     * Update an existing order
     */
    @Override
    public void update(Order order) {
        Optional<Order> result = orderDao.findById(order.getId());
        if (result.isPresent()) {
            orderDao.save(order);
        }
    }

    /*
     * Delete an existing order
     */
    @Override
    public void delete(int id) {
        Optional<Order> result = orderDao.findById(id);
        if (result.isPresent()) {
            orderDao.delete(result.get());
        }
    }

    /*
     * Return orders whose price is less than given price
     */
    @Override
    public List<Order> getAllByPriceLessThan(double price) {
        return orderDao.getAllByPriceLessThan(price);
    }

    /*
     * Return orders whose price is more than given price
     */
    @Override
    public List<Order> getAllByPriceMoreThan(double price) {
        return orderDao.getAllByPriceGreaterThan(price);
    }

    /*
     * Return total order price according to given customer register month
     */
    @Override
    public double getSumByCustomerRegisterDate(int month) {
        return orderDao.getSumByCustomer_RegisterDate(month);
    }

    /*
     * Return all orders according to given customer register month
     */
    @Override
    public List<Order> getAllByCustomerRegisterDate(int month) {
        return orderDao.getAllByCustomer_RegisterDate(month);
    }

    /*
     * Return order average price which is less than given price
     */
    @Override
    public double getAverageByPriceGreaterThan(double price) {
        return orderDao.getAverageByPriceGreaterThan(price);
    }

}

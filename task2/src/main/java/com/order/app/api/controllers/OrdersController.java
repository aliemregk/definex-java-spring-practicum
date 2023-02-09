package com.order.app.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.app.business.abstracts.OrderService;
import com.order.app.entities.concretes.Order;

/*
 * OrdersController class
 * Controller class for Order Entity
 * Defines Order Entity's endpoints
 */
@RestController
@RequestMapping(path = "/api/orders")
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*
     * Get Request to /api/orders/getall
     * Return all orders
     */
    @GetMapping(path = "/getall")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    /*
     * Get Request to /api/orders/getbyid
     * Return one order according to given id
     */
    @GetMapping(path = "/getbyid")
    public Order getById(@RequestParam int id) {
        return orderService.getById(id);
    }

    /*
     * Post Request to /api/orders/add
     * Add a new order
     */
    @PostMapping(path = "/add")
    public void add(@RequestBody Order order) {
        orderService.add(order);
    }

    /*
     * Put Request to /api/orders/update
     * Update an existing order
     */
    @PutMapping(path = "/update")
    public void update(@RequestBody Order order) {
        orderService.update(order);
    }

    /*
     * Delete Request to /api/orders/delete
     * Delete an existing order
     */
    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam int id) {
        orderService.delete(id);
    }

    /*
     * Get Request to /api/orders/getallbypricelessthan
     * Return orders whose price is less than given price
     */
    @GetMapping(path = "/getallbypricelessthan")
    public List<Order> getAllByPriceLessThan(@RequestParam double price) {
        return orderService.getAllByPriceLessThan(price);
    }

    /*
     * Get Request to /api/orders/getallbypricegreaterthan
     * Return orders whose price is more than given price
     */
    @GetMapping(path = "/getallbypricegreaterthan")
    public List<Order> getAllByPriceMoreThan(@RequestParam double price) {
        return orderService.getAllByPriceMoreThan(price);
    }

    /*
     * Get Request to /api/orders/getsumbycustomerregisterdate
     * Return total order price according to given customer register month
     */
    @GetMapping(path = "/getsumbycustomerregisterdate")
    public double getSumByCustomerRegisterDate(@RequestParam int month) {
        return orderService.getSumByCustomerRegisterDate(month);
    }

    /*
     * Get Request to /api/orders/getallbycustomerregisterdate
     * Return all orders according to given customer register month
     */
    @GetMapping(path = "/getallbycustomerregisterdate")
    public List<Order> getAllByCustomerRegisterDate(@RequestParam int month) {
        return orderService.getAllByCustomerRegisterDate(month);
    }

    /*
     * Get Request to /api/orders/getaveragebypricegreaterthan
     * Return order average price which is less than given price
     */
    @GetMapping(path = "/getaveragebypricegreaterthan")
    public double getAverageByPriceGreaterThan(@RequestParam double price) {
        return orderService.getAverageByPriceGreaterThan(price);
    }
}

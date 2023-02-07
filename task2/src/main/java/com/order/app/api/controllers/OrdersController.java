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

@RestController
@RequestMapping(path = "/api/orders")
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/getall")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping(path = "/getbyid")
    public Order getById(@RequestParam int id) {
        return orderService.getById(id);
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody Order order) {
        orderService.add(order);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody Order order) {
        orderService.update(order);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam int id) {
        orderService.delete(id);
    }

    @GetMapping(path = "/getallbypricelessthan")
    public List<Order> getAllByPriceLessThan(@RequestParam double price) {
        return orderService.getAllByPriceLessThan(price);
    }

    @GetMapping(path = "/getallbypricegreaterthan")
    public List<Order> getAllByPriceMoreThan(@RequestParam double price) {
        return orderService.getAllByPriceMoreThan(price);
    }

    @GetMapping(path = "/getsumbycustomerregisterdate")
    public double getSumByCustomerRegisterDate(@RequestParam int month) {
        return orderService.getSumByCustomerRegisterDate(month);
    }

    @GetMapping(path = "/getallbycustomerregisterdate")
    public List<Order> getAllByCustomerRegisterDate(@RequestParam int month) {
        return orderService.getAllByCustomerRegisterDate(month);
    }

    @GetMapping(path = "/getaveragebypricegreaterthan")
    public double getAverageByPriceGreaterThan(@RequestParam double price) {
        return orderService.getAverageByPriceGreaterThan(price);
    }
}

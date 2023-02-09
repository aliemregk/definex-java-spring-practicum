package com.order.app.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.app.business.abstracts.CustomerService;
import com.order.app.entities.concretes.Customer;

/*
 * CustomersController class
 * Controller class for Customer Entity
 * Defines Customer Entity's endpoints
 */
@RestController
@RequestMapping(path = "/api/customers")
public class CustomersController {

    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*
     * Get Request to /api/customers/getall
     * Return all customers
     */
    @GetMapping(path = "/getall")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    /*
     * Get Request to /api/customers/getbyid
     * Return one customer according to given id
     */
    @GetMapping(path = "/getbyid")
    public Customer getById(@RequestParam int id) {
        return customerService.getById(id);
    }

    /*
     * Post Request to /api/customers/add
     * Add a new customer
     */
    @PostMapping(path = "/add")
    public void add(@RequestBody Customer customer) {
        customerService.add(customer);
    }

    /*
     * Put Request to /api/customers/update
     * Update an existing customer
     */
    @PutMapping(path = "/update")
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }

    /*
     * Delete Request to /api/customers/delete
     * Delete an existing customer
     */
    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam int id) {
        customerService.delete(id);
    }

    /* 
     * Get Request to /api/customers/getallbyfirstnamecontains
     * Return customers whose name contains given letter
     */
    @GetMapping(path = "/getallbyfirstnamecontains")
    public List<Customer> getAllByFirstNameContains(@RequestParam String letter) {
        return customerService.getAllByFirstNameContains(letter);
    }

    /* 
     * Get Request to /api/customers/getallbyregisterdate
     * Return customers according to given register date
     */
    @GetMapping(path = "/getallbyregisterdate")
    public List<Customer> getAllByRegisterDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return customerService.getAllByRegisterDate(date);
    }

    /* 
     * Get Request to /api/customers/getallbyorderpricelessthan
     * Return customers who have an order whose price is less than given amount
     */
    @GetMapping(path = "/getallbyorderpricelessthan")
    public List<Customer> getAllByOrderPriceLessThan(@RequestParam double price) {
        return customerService.getAllByOrderPriceLessThan(price);
    }
}

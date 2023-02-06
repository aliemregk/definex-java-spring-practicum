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

@RestController
@RequestMapping(path = "/api/customers")
public class CustomersController {

    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/getall")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping(path = "/getbyid")
    public Customer getById(@RequestParam int id) {
        return customerService.getById(id);
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody Customer customer) {
        customerService.add(customer);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam int id) {
        customerService.delete(id);
    }

    @GetMapping(path = "/getallbyfirstnamecontains")
    public List<Customer> getAllByFirstNameContains(@RequestParam String letter) {
        return customerService.getAllByFirstNameContains(letter);
    }

    @GetMapping(path = "/getallbyregisterdate")
    public List<Customer> getAllByRegisterDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return customerService.getAllByRegisterDate(date);
    }
}

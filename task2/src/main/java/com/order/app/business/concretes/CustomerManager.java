package com.order.app.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.order.app.business.abstracts.CustomerService;
import com.order.app.dataaccess.abstracts.CustomerDao;
import com.order.app.entities.concretes.Customer;

/*
 * CustomerManager class implements CustomerService
 * Business class for Customer Entity
 */
@Service
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /* 
     * Return all customers
     */
    @Override
    public List<Customer> getAll() {
        return customerDao.findAll(Sort.by(Direction.ASC, "id"));
    }

    /* 
     * Return one customer according to given id
     */
    @Override
    public Customer getById(int id) {
        Optional<Customer> result = customerDao.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    /* 
     * Add a new customer
     */
    @Override
    public void add(Customer customer) {
        customerDao.save(customer);
    }

    /* 
     * Update an existing customer
     */
    @Override
    public void update(Customer customer) {
        Optional<Customer> result = customerDao.findById(customer.getId());
        if (result.isPresent()) {
            customerDao.save(customer);
        }
    }

    /* 
     * Delete an existing customer
     */
    @Override
    public void delete(int id) {
        Optional<Customer> result = customerDao.findById(id);
        if (result.isPresent()) {
            customerDao.delete(result.get());
        }
    }

    /* 
     * Return customers whose name contains given letter
     */
    @Override
    public List<Customer> getAllByFirstNameContains(String letter) {
        return customerDao.getAllByFirstNameContainsIgnoreCase(letter);
    }

    /* 
     * Return customers according to given register date
     */
    @Override
    public List<Customer> getAllByRegisterDate(LocalDate date) {
        return customerDao.getAllByRegisterDate(date);
    }

    /* 
     * Return customers who have an order whose price is less than given amount
     */
    @Override
    public List<Customer> getAllByOrderPriceLessThan(double price) {
        return customerDao.getAllByOrders_PriceLessThan(price);
    }

}

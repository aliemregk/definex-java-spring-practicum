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

@Service
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.findAll(Sort.by(Direction.ASC, "id"));
    }

    @Override
    public Customer getById(int id) {
        Optional<Customer> result = customerDao.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void add(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void update(Customer customer) {
        Optional<Customer> result = customerDao.findById(customer.getId());
        if (result.isPresent()) {
            customerDao.save(customer);
        }
    }

    @Override
    public void delete(int id) {
        Optional<Customer> result = customerDao.findById(id);
        if (result.isPresent()) {
            customerDao.delete(result.get());
        }
    }

    @Override
    public List<Customer> getAllByFirstNameContains(String letter) {
        return customerDao.getAllByFirstNameContains(letter);
    }

    @Override
    public List<Customer> getAllByRegisterDate(LocalDate date) {
        return customerDao.getAllByRegisterDate(date);
    }

}

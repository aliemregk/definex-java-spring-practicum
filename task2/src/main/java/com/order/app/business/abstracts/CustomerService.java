package com.order.app.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.order.app.entities.concretes.Customer;

/*
 * CustomerService interface extends BaseService
 * Defines Customer entity-specific functions
 */
public interface CustomerService extends BaseService<Customer> {

    List<Customer> getAllByFirstNameContains(String letter);

    List<Customer> getAllByRegisterDate(LocalDate date);

    List<Customer> getAllByOrderPriceLessThan(double price);
}
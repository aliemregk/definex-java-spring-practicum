package com.order.app.dataaccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.app.entities.concretes.Customer;

/*
 * CustomerDao interface
 * Keeps Customer entity's sql queries and functions by using JpaRepository
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    
    List<Customer> getAllByFirstNameContainsIgnoreCase(String letter);

    List<Customer> getAllByRegisterDate(LocalDate date);

    List<Customer> getAllByOrders_PriceLessThan(double price);
}

package com.order.app.dataaccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.app.entities.concretes.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
    
}

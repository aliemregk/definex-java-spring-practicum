package com.order.app.dataaccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.app.entities.concretes.Company;

/*
 * CompanyDao interface
 * Keeps Company entity's sql queries and functions by using JpaRepository
 */
@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> {

    @Query(value = "select DISTINCT c.id, c.name, c.field from companies c inner join orders o on o.company_id = c.id group by c.id,  o.date having EXTRACT(MONTH FROM o.date) = ?1 and avg(o.price) < ?2", nativeQuery = true)
    List<Company> getAllByMonthlyPriceAverage(int month, double price);

    @Query("SELECT c FROM Company c join c.orders o WHERE month(o.date) = ?1")
    List<Company> getAllByOrders_Date(int month);

}

package com.order.app.business.abstracts;

import java.util.List;

import com.order.app.entities.concretes.Company;

/*
 * CompanyService interface extends BaseService
 * Defines Company entity-specific functions
 */
public interface CompanyService extends BaseService<Company> {

    List<Company> getAllByMonthlyPriceAverage(int month, double price);

    List<Company> getAllByOrderDate(int month); 

}

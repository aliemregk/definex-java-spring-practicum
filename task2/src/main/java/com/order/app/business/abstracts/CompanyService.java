package com.order.app.business.abstracts;

import java.util.List;

import com.order.app.entities.concretes.Company;

public interface CompanyService extends BaseService<Company> {

    List<Company> getAllByMonthlyPriceAverage(int month, double price);

    List<Company> getAllByOrderDate(int month); 

}

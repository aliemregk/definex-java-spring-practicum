package com.order.app.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.order.app.business.abstracts.CompanyService;
import com.order.app.dataaccess.abstracts.CompanyDao;
import com.order.app.entities.concretes.Company;

/*
 * CompanyManager class implements CompanyService
 * Business class for Company Entity
 */
@Service
public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;

    @Autowired
    public CompanyManager(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    /*
     * Return all companies
     */
    @Override
    public List<Company> getAll() {
        return companyDao.findAll(Sort.by(Direction.ASC, "id"));
    }

    /*
     * Return one company according to given id
     */
    @Override
    public Company getById(int id) {
        Optional<Company> result = companyDao.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    /*
     * Add a new company
     */
    @Override
    public void add(Company company) {
        companyDao.save(company);
    }

    /*
     * Update an existing company
     */
    @Override
    public void update(Company company) {
        Optional<Company> result = companyDao.findById(company.getId());
        if (result.isPresent()) {
            companyDao.save(company);
        }
    }

    /*
     * Delete an existing company
     */
    @Override
    public void delete(int id) {
        Optional<Company> result = companyDao.findById(id);
        if (result.isPresent()) {
            companyDao.delete(result.get());
        }
    }

    /*
     * Return companies which have orders whose average price is less than given
     * price in given month
     */
    @Override
    public List<Company> getAllByMonthlyPriceAverage(int month, double price) {
        return companyDao.getAllByMonthlyPriceAverage(month, price);
    }

    /*
     * Return companies which have orders in given month
     */
    @Override
    public List<Company> getAllByOrderDate(int month) {
        return companyDao.getAllByOrders_Date(month);
    }

}

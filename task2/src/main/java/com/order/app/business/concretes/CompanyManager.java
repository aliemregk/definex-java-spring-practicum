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

@Service
public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;

    @Autowired
    public CompanyManager(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public List<Company> getAll() {
        return companyDao.findAll(Sort.by(Direction.ASC, "id"));
    }

    @Override
    public Company getById(int id) {
        Optional<Company> result = companyDao.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public void add(Company company) {
        companyDao.save(company);
    }

    @Override
    public void update(Company company) {
        Optional<Company> result = companyDao.findById(company.getId());
        if (result.isPresent()) {
            companyDao.save(company);
        }
    }

    @Override
    public void delete(int id) {
        Optional<Company> result = companyDao.findById(id);
        if (result.isPresent()) {
            companyDao.delete(result.get());
        }
    }

    @Override
    public List<Company> getAllByMonthlyPriceAverage(int month, double price) {
        return companyDao.getAllByMonthlyPriceAverage(month, price);
    }

    @Override
    public List<Company> getAllByOrderDate(int month) { 
        return companyDao.getAllByOrders_Date(month);
    }

}

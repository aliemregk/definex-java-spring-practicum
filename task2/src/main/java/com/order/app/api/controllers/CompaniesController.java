package com.order.app.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.app.business.abstracts.CompanyService;
import com.order.app.entities.concretes.Company;

/*
 * CompaniesController class
 * Controller class for Company Entity
 * Defines Company Entity's endpoints
 */
@RestController
@RequestMapping(path = "/api/companies")
public class CompaniesController {

    private CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /*
     * Get Request to /api/companies/getall
     * Return all companies
     */
    @GetMapping(path = "/getall")
    public List<Company> getAll() {
        return companyService.getAll();
    }

    /*
     * Get Request to /api/companies/getbyid
     * Return one company according to given id
     */
    @GetMapping(path = "/getbyid")
    public Company getById(@RequestParam int id) {
        return companyService.getById(id);
    }

    /*
     * Post Request to /api/companies/add
     * Add a new company
     */
    @PostMapping(path = "/add")
    public void add(@RequestBody Company company) {
        companyService.add(company);
    }

    /*
     * Put Request to /api/companies/update
     * Update an existing company
     */
    @PutMapping(path = "/update")
    public void update(@RequestBody Company company) {
        companyService.update(company);
    }

    /*
     * Delete Request to /api/companies/delete
     * Delete an existing company
     */
    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam int id) {
        companyService.delete(id);
    }

    /*
     * Get Request to /api/companies/getallbymonthlypriceaverage
     * Return companies which have orders whose average price is less than given
     * price in given month
     */
    @GetMapping(path = "/getallbymonthlypriceaverage")
    public List<Company> getAllByMonthlyPriceAverage(@RequestParam int month, @RequestParam double price) {
        return companyService.getAllByMonthlyPriceAverage(month, price);
    }

    /*
     * Get Request to /api/companies/getallbyorderdate
     * Return companies which have orders in given month
     */
    @GetMapping(path = "/getallbyorderdate")
    public List<Company> getAllByOrderDate(@RequestParam int month) {
        return companyService.getAllByOrderDate(month);
    }

}

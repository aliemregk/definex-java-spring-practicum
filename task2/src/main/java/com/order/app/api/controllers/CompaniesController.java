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

@RestController
@RequestMapping(path = "/api/companies")
public class CompaniesController {

    private CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "/getall")
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping(path = "/getbyid")
    public Company getById(@RequestParam int id) {
        return companyService.getById(id);
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody Company company) {
        companyService.add(company);
    }

    @PutMapping(path = "/update")
    public void update(@RequestBody Company company) {
        companyService.update(company);
    }

    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam int id) {
        companyService.delete(id);
    }

}

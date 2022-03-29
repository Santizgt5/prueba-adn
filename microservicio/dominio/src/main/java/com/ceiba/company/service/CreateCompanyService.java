package com.ceiba.company.service;

import com.ceiba.company.model.entity.Company;
import com.ceiba.company.port.repository.CompanyRepository;

public class CreateCompanyService {

    private final CompanyRepository companyRepository;

    public CreateCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public int ejecutar(Company company) {
        return this.companyRepository.crear(company);
    }
}

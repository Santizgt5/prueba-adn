package com.ceiba.company.service;

import com.ceiba.company.model.entity.Company;
import com.ceiba.company.port.repository.CompanyRepository;

public class UpdateCompanyService {

    private final CompanyRepository companyRepository;

    public UpdateCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public void ejecutar(Company company) {
        this.companyRepository.actualizar(company);
    }

}

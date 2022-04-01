package com.ceiba.company.service;

import com.ceiba.company.model.entity.Company;
import com.ceiba.company.port.repository.CompanyRepository;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class UpdateCompanyService {

    private static final String COMPANY_DOESNT_EXIST = "The company doesn't exist";

    private final CompanyRepository companyRepository;

    public UpdateCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public void ejecutar(Company company) {
        existValidation(company);
        this.companyRepository.actualizar(company);
    }

    private void existValidation(Company company) {
        boolean exist = this.companyRepository.existById(company.getId());
        if(!exist) {
            throw new ExcepcionDuplicidad(COMPANY_DOESNT_EXIST);
        }
    }

}

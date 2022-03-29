package com.ceiba.company.command.handler;

import com.ceiba.company.command.CommandCompany;
import com.ceiba.company.command.factory.CompanyFactory;
import com.ceiba.company.model.entity.Company;
import com.ceiba.company.service.UpdateCompanyService;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class UpdateCompanyHandler implements ManejadorComando<CommandCompany> {

    private final CompanyFactory companyFactory;
    private final UpdateCompanyService updateCompanyService;


    public UpdateCompanyHandler(CompanyFactory companyFactory, UpdateCompanyService updateCompanyService) {
        this.companyFactory = companyFactory;
        this.updateCompanyService = updateCompanyService;
    }


    @Override
    public void ejecutar(CommandCompany comando) {
        Company company = this.companyFactory.crear(comando);
        this.updateCompanyService.ejecutar(company);
    }
}

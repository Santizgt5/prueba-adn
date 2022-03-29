package com.ceiba.company.command.handler;

import com.ceiba.ComandoRespuesta;
import com.ceiba.company.command.CommandCompany;
import com.ceiba.company.command.factory.CompanyFactory;
import com.ceiba.company.model.entity.Company;
import com.ceiba.company.service.CreateCompanyService;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyHandler implements ManejadorComandoRespuesta<CommandCompany, ComandoRespuesta<Integer>> {

    private final CompanyFactory companyFactory;
    private final CreateCompanyService createCompanyService;

    public CreateCompanyHandler(CompanyFactory companyFactory, CreateCompanyService createCompanyService) {
        this.companyFactory = companyFactory;
        this.createCompanyService = createCompanyService;
    }


    @Override
    public ComandoRespuesta<Integer> ejecutar(CommandCompany commandCompany) {
        Company company = this.companyFactory.crear(commandCompany);
        return new ComandoRespuesta<>(this.createCompanyService.ejecutar(company));
    }
}

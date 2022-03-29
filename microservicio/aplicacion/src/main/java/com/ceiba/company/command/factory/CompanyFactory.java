package com.ceiba.company.command.factory;

import com.ceiba.company.command.CommandCompany;
import com.ceiba.company.model.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyFactory {

    public Company crear(CommandCompany commandCompany) {
        return new Company(
                commandCompany.getId(),
                commandCompany.getName(),
                commandCompany.getDescription(),
                commandCompany.getBorn(),
                commandCompany.getNit()
        );
    }


}

package com.ceiba.company.query;

import com.ceiba.company.model.dto.DtoCompany;
import com.ceiba.company.port.dao.DaoCompany;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandlerListCompany {

    private final DaoCompany daoCompany;


    public HandlerListCompany(DaoCompany daoCompany) {
        this.daoCompany = daoCompany;
    }

    public List<DtoCompany> ejecutar() { return  this.daoCompany.listar(); }

}

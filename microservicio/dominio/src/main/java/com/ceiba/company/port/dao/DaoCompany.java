package com.ceiba.company.port.dao;

import com.ceiba.company.model.dto.DtoCompany;

import java.util.List;

public interface DaoCompany {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoCompany> listar();


}

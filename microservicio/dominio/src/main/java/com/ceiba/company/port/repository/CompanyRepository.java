package com.ceiba.company.port.repository;

import com.ceiba.company.model.entity.Company;

public interface CompanyRepository {

    /**
     * Permite crear un usuario
     * @param company
     * @return el id generado
     */
    int crear(Company company);

    /**
     * Permite actualizar un usuario
     * @param company
     */
    void actualizar(Company company);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existById(int id);

}

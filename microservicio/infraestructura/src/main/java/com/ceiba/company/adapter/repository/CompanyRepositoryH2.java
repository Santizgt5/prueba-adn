package com.ceiba.company.adapter.repository;

import com.ceiba.company.model.entity.Company;
import com.ceiba.company.port.repository.CompanyRepository;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepositoryH2 implements CompanyRepository {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public CompanyRepositoryH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="company", value="create")
    private static String sqlCrear;

    @SqlStatement(namespace="company", value="update")
    private static String sqlUpdate;


    @Override
    public int crear(Company company) {
        return this.customNamedParameterJdbcTemplate.createWithoutDto(company, sqlCrear);
    }

    @Override
    public void actualizar(Company company) {
        this.customNamedParameterJdbcTemplate.actualizar(company, sqlUpdate);
    }

    @Override
    public boolean existe(String nombre) {
        return false;
    }

    @Override
    public boolean existePorId(int id) {
        return false;
    }
}

package com.ceiba.company.adapter.repository;

import com.ceiba.company.model.entity.Company;
import com.ceiba.company.port.repository.CompanyRepository;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    @SqlStatement(namespace="company", value="existById")
    private static String sqlExistById;

    @Override
    public int crear(Company company) {
        return this.customNamedParameterJdbcTemplate.createWithoutDto(company, sqlCrear);
    }

    @Override
    public void actualizar(Company company) {
        this.customNamedParameterJdbcTemplate.actualizar(company, sqlUpdate);
    }

    @Override
    public boolean existById(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistById,paramSource, Boolean.class);
    }

}

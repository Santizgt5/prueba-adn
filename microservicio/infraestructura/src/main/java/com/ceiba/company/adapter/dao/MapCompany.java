package com.ceiba.company.adapter.dao;

import com.ceiba.company.model.dto.DtoCompany;
import com.ceiba.infraestructura.jdbc.MapperResult;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapCompany implements RowMapper<DtoCompany>, MapperResult {

    @Override
    public DtoCompany mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt("company_id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        LocalDate born = extraerLocalDate(resultSet, "born");
        String nit = resultSet.getString("nit");

        return new DtoCompany(id, name, description, born, nit);

    }

}

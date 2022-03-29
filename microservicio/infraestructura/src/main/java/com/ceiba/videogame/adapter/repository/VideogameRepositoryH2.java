package com.ceiba.videogame.adapter.repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VideogameRepositoryH2 implements VideogameRepository {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="videogame", value="create")
    private static String sqlCrear;

    @SqlStatement(namespace="videogame", value="update")
    private static String sqlUpdate;

    public VideogameRepositoryH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate1) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate1;
    }


    @Override
    public int crear(DtoVideogame videogame) {
        return this.customNamedParameterJdbcTemplate.create(videogame, sqlCrear);
    }

    @Override
    public void actualizar(DtoVideogame videogame) {
        this.customNamedParameterJdbcTemplate.actualizar(videogame, sqlUpdate);
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

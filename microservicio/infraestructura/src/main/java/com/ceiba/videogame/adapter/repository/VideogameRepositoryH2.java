package com.ceiba.videogame.adapter.repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.videogame.model.dto.DtoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Repository
public class VideogameRepositoryH2 implements VideogameRepository {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @SqlStatement(namespace="videogame", value="create")
    private static String sqlCrear;

    @SqlStatement(namespace="videogame", value="update")
    private static String sqlUpdate;

    @SqlStatement(namespace="videogame", value="getById")
    private static String sqlGet;

    @SqlStatement(namespace="videogame", value="existById")
    private static String sqlExistById;

    public VideogameRepositoryH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate1, NamedParameterJdbcTemplate namedParameterJdbcTemplate1) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate1;

        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate1;
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
    public DtoVideogame getVideogameById(int videogameId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", videogameId);
        return this.namedParameterJdbcTemplate.query(sqlGet, parameterSource, row -> {
            row.next();
            Integer id = row.getInt("videogame_id");
            String title = row.getString("title");
            Integer stock = row.getInt("stock");
            Integer companyId = row.getInt("companyId");
            Date releaseDate = row.getDate("releaseDate");
            String platform = row.getString("platform");
            Double price = row.getDouble("price");
            LocalDate releaseDateVideogame = Instant.ofEpochMilli(releaseDate.getTime())
                    .atZone( ZoneId.systemDefault() )
                    .toLocalDate();
            return DtoVideogame.builder().id(id).title(title).stock(stock).companyId(companyId).platform(platform).price(price).releaseDate(releaseDateVideogame).build();
        });
    }

    @Override
    public boolean existById(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistById,paramSource, Boolean.class);
    }


}

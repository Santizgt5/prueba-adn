package com.ceiba.videogame.adapter.dao;

import com.ceiba.company.model.entity.Company;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.videogame.model.entity.Videogame;
import com.ceiba.videogame.port.dao.DaoVideogame;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DaoVideogameH2 implements DaoVideogame {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @SqlStatement(namespace="videogame", value="list")
    private static String sqlList;


    public DaoVideogameH2(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Videogame> listar() {
        List<Videogame> videogames = new ArrayList<>();
        this.namedParameterJdbcTemplate.getJdbcTemplate().query(sqlList, row -> {

            Integer id = row.getInt("videogame_id");
            String title = row.getString("title");
            Integer stock = row.getInt("stock");
            Integer companyId = row.getInt("companyId");
            Date releaseDate = row.getDate("releaseDate");
            String platform = row.getString("platform");
            Double price = row.getDouble("price");
            Date born = row.getDate("born");
            LocalDate releaseDate_videogame = Instant.ofEpochMilli(releaseDate.getTime())
                    .atZone( ZoneId.systemDefault() )
                    .toLocalDate();
            LocalDate born_company = Instant.ofEpochMilli(born.getTime())
                    .atZone( ZoneId.systemDefault() )
                    .toLocalDate();
            Company company = new Company( row.getInt("company_id"), row.getString("name"),row.getString("description"), born_company, row.getString("nit"));
            Videogame videogame = new Videogame( id, title, stock, company, releaseDate_videogame, platform, price );
            videogames.add(videogame);
        });

        return videogames;
    }

}

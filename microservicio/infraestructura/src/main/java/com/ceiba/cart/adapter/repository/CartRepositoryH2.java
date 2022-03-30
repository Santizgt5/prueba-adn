package com.ceiba.cart.adapter.repository;

import com.ceiba.cart.model.dto.DtoCart;
import com.ceiba.cart.port.repository.CartRepository;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryH2 implements CartRepository {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public CartRepositoryH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="cart", value="create")
    private static String sqlCrear;

    @Override
    public int crear(DtoCart cart) {
        return this.customNamedParameterJdbcTemplate.create(cart, sqlCrear);
    }
}

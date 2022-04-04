package com.ceiba.company.controller;

import com.ceiba.company.model.dto.DtoCompany;
import com.ceiba.company.model.entity.Company;
import com.ceiba.company.query.HandlerListCompany;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class QueryCompanyController {

    private final HandlerListCompany handlerListCompany;


    public QueryCompanyController(HandlerListCompany handlerListCompany) {
        this.handlerListCompany = handlerListCompany;
    }

    @GetMapping
    public List<DtoCompany> list() { return this.handlerListCompany.ejecutar(); }
}

package com.ceiba.company.controller;

import com.ceiba.ComandoRespuesta;
import com.ceiba.company.command.CommandCompany;
import com.ceiba.company.command.handler.CreateCompanyHandler;
import com.ceiba.company.command.handler.UpdateCompanyHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CommandCompanyController {

    private final CreateCompanyHandler createCompanyHandler;
    private final UpdateCompanyHandler updateCompanyHandler;


    public CommandCompanyController(CreateCompanyHandler createCompanyHandler, UpdateCompanyHandler updateCompanyHandler) {
        this.createCompanyHandler = createCompanyHandler;
        this.updateCompanyHandler = updateCompanyHandler;
    }

    @PostMapping
    public ComandoRespuesta<Integer> crear(@RequestBody CommandCompany commandCompany) {
        return createCompanyHandler.ejecutar(commandCompany);
    }

    @PutMapping(value = "/{id}")
    public void actualizar(@RequestBody CommandCompany commandCompany, @PathVariable int id) {
        commandCompany.setId(id);
        updateCompanyHandler.ejecutar(commandCompany);
    }

}

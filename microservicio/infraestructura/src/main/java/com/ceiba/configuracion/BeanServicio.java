package com.ceiba.configuracion;

import com.ceiba.cart.CartValidations;
import com.ceiba.cart.service.BuyVideogamesService;
import com.ceiba.cart.service.CalcuateQuantityDiscountService;
import com.ceiba.company.port.repository.CompanyRepository;
import com.ceiba.company.service.CreateCompanyService;
import com.ceiba.company.service.UpdateCompanyService;
import com.ceiba.videogame.port.dao.DaoVideogame;
import com.ceiba.videogame.port.repository.VideogameRepository;
import com.ceiba.videogame.service.CreateVideogameService;
import com.ceiba.videogame.service.UpdateVideogameService;
import com.ceiba.videogame.service.VerifyDiscountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public CreateVideogameService createVideogameService(VideogameRepository videogameRepository) {
        return  new CreateVideogameService(videogameRepository);
    }
    @Bean
    public UpdateVideogameService updateVideogameService(VideogameRepository videogameRepository) {
        return  new UpdateVideogameService(videogameRepository);
    }

    @Bean
    public CreateCompanyService createCompanyService(CompanyRepository companyRepository) {
        return  new CreateCompanyService(companyRepository);
    }
    @Bean
    public UpdateCompanyService updateCompanyService(CompanyRepository companyRepository) {
        return  new UpdateCompanyService(companyRepository);
    }

    @Bean
    public CalcuateQuantityDiscountService createCartService() {
        return new CalcuateQuantityDiscountService();
    }

    @Bean
    public VerifyDiscountService verifyDiscountService(DaoVideogame daoVideogame) {
        return new VerifyDiscountService(daoVideogame);
    }

    @Bean
    public BuyVideogamesService buyVideogamesService(VideogameRepository videogameRepository, CartValidations cartValidations) {
        return new BuyVideogamesService(videogameRepository, cartValidations);
    }

}

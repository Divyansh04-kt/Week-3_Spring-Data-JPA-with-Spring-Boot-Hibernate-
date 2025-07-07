package com.cognizant.orm_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static CountryService countryService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testAddCountry();  // Call the test here
    }
    
    private static void testAddCountry() {
        LOGGER.info("Start");

        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zootopia");

        countryService.addCountry(country);  // Add the country

        Country saved = countryService.findCountryByCode("ZZ"); // Retrieve it
        LOGGER.debug("Saved Country: {}", saved);

        LOGGER.info("End");
    }
    
    
}

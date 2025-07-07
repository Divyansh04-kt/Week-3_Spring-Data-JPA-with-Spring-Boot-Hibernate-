package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void testFindCountryByCode() {
        Country country = countryService.findCountryByCode("IN");
        assertNotNull(country);
        assertEquals("India", country.getName());
        System.out.println("✅ testFindCountryByCode PASSED: " + country.getName());
    }

    @Test
    public void testAddCountry() {
        Country newCountry = new Country();
        newCountry.setCode("ZZ");
        newCountry.setName("Zootopia");

        countryService.addCountry(newCountry);

        Country fetched = countryService.findCountryByCode("ZZ");
        assertNotNull(fetched);
        assertEquals("Zootopia", fetched.getName());
        System.out.println("✅ testAddCountry PASSED: " + fetched.getName());
    }
}

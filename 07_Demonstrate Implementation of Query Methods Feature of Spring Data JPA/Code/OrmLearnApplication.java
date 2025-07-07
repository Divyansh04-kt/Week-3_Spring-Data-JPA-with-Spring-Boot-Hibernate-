package com.cognizant.orm_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.*;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Search countries containing 'ou'
        System.out.println("Countries containing 'ou' are : ");
        List<Country> result1 = countryRepository.findByCountrynameContainingIgnoreCase("ou");
        result1.forEach(System.out::println);

        // Same as above but ordered by name
        System.out.println("\nCountries containing 'ou' (sorted ascending) are : ");
        List<Country> result2 = countryRepository.findByCountrynameContainingIgnoreCaseOrderByCountrynameAsc("ou");
        result2.forEach(System.out::println);

        // Countries starting with 'Z'
        System.out.println("\nCountries starting with 'Z' are : ");
        List<Country> result3 = countryRepository.findByCountrynameStartingWithIgnoreCase("Z");
        result3.forEach(System.out::println);
    }   
}

package com.cognizant.orm_learn.service;

import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;
    
    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }
 
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    
    
}

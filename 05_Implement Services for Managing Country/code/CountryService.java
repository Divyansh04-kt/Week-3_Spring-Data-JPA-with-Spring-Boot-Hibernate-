package com.cognizant.orm_learn.service;

import java.util.List;
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

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public void updateCountry(Country country) {
        countryRepository.save(country);
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> findCountriesByPartialName(String namePart) {
        return countryRepository.findByCountrynameContaining(namePart);
    }

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}

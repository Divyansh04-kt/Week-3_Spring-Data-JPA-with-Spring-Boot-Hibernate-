package com.cognizant.orm_learn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.orm_learn.model.Country;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Searching by partial name (case-insensitive)
    List<Country> findByCountrynameContainingIgnoreCase(String keyword);

    // Same as above but results ordered ascending by name
    List<Country> findByCountrynameContainingIgnoreCaseOrderByCountrynameAsc(String keyword);

    // Searching by starting alphabet
    List<Country> findByCountrynameStartingWithIgnoreCase(String alphabet);
}

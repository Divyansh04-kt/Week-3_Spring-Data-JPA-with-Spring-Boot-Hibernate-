package com.cognizant.orm_learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="Code")
    private String code;

    @Column(name="CountryName")
    private String countryname;
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setName(String countryname) {
        this.countryname = countryname;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return countryname;
    }

    @Override
    public String toString() {
        return code + " - " + countryname;
    }
}

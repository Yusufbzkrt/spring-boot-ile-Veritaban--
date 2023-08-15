package com.example.stajLig.Service;

import com.example.stajLig.Entity.Country;


import java.util.List;

public interface CountryService {
    Country createCountry(Country country);

    List<Country> getCountry();
    Country updateCountry(Long id,Country country);
    Boolean deleteCountry(Long id);
}

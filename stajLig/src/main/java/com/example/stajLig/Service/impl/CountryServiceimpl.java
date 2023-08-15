package com.example.stajLig.Service.impl;

import com.example.stajLig.Entity.Country;

import com.example.stajLig.Repository.CountryRepository;

import com.example.stajLig.Service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceimpl implements CountryService {
private final CountryRepository countryRepository;
    @Override
    public Country createCountry(Country country) {
        country.setCreateAt(new Date());
        country.setCreateBy("admin");
        return countryRepository.save(country);
    }
    @Override
    public List<Country> getCountry() {

        return countryRepository.findAll();
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        Optional<Country> resultCountry=countryRepository.findById(id);
        if (resultCountry.isPresent()){
            resultCountry.get().setName(country.getName());
            resultCountry.get().setContinent(country.getContinent());
            resultCountry.get().setUpdatedAt(new Date());
            resultCountry.get().setUpdateBy("admin");
            return countryRepository.save(resultCountry.get());
        }
        return null;
    }

    @Override
    public Boolean deleteCountry(Long id) {
        Optional<Country> delcountry = countryRepository.findById(id);
        if (delcountry.isPresent()){
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

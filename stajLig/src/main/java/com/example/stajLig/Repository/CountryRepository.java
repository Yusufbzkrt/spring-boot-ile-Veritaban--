package com.example.stajLig.Repository;

import com.example.stajLig.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CountryRepository extends JpaRepository<Country,Long> {


}



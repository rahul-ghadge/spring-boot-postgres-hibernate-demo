package com.postgres.hibernate.projections.service;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.models.dto.CountryDto;
import com.postgres.hibernate.models.dto.CountryView;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    void save();

    List<CountryDto> findByCountryName(String countryName);

    List<Object[]> getCountryDetails(String countryName);

    List<CountryDto> findByCountryNameConstructor(String countryName);

    CountryView findViewByCountryName(String countryName);

}

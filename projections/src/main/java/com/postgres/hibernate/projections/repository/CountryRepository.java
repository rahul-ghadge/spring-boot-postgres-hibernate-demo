package com.postgres.hibernate.projections.repository;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.models.dto.CountryDto;
import com.postgres.hibernate.models.dto.CountryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    List<CountryDto> findByCountryName(String countryName);

    @Query("SELECT c.id, c.countryName, c.continent FROM Country c WHERE c.countryName = :countryName")
    List<Object[]> getCountryDetails(String countryName);

    @Query("SELECT new com.postgres.hibernate.models.dto.CountryDto(c.id, c.countryName, c.continent) FROM Country c WHERE c.countryName = :countryName")
    List<CountryDto> findByCountryNameConstructor(String countryName);

    CountryView findViewByCountryName(String countryName);


}
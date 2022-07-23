package com.postgres.hibernate.projections.service.impl;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.models.DialInDetails;
import com.postgres.hibernate.models.dto.CountryDto;
import com.postgres.hibernate.models.dto.CountryView;
import com.postgres.hibernate.projections.repository.CountryRepository;
import com.postgres.hibernate.projections.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public void save() {

        Country india = new Country("India", "ASIA");
        DialInDetails dialInDetailsIndia = new DialInDetails("IN", "91");
        india.setDialInDetails(dialInDetailsIndia);

        Country usa = new Country("USA", "USA");
        DialInDetails dialInDetailsUsa = new DialInDetails("US", "1");
        usa.setDialInDetails(dialInDetailsUsa);

        Country netherlands = new Country("Netherlands", "EUROPE");
        DialInDetails dialInDetailsNetherlands = new DialInDetails("NL", "31");
        netherlands.setDialInDetails(dialInDetailsNetherlands);

        LOGGER.info("Saving :: {}", india);
        countryRepository.save(india);
        LOGGER.info("Saving :: {}", usa);
        countryRepository.save(usa);
        LOGGER.info("Saving :: {}", netherlands);
        countryRepository.save(netherlands);

    }

    @Override
    public List<CountryDto> findByCountryName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }

    @Override
    public List<Object[]> getCountryDetails(String countryName) {
        return countryRepository.getCountryDetails(countryName);
    }

    @Override
    public List<CountryDto> findByCountryNameConstructor(String countryName) {
        return countryRepository.findByCountryNameConstructor(countryName);
    }

    @Override
    public CountryView findViewByCountryName(String countryName) {
        return countryRepository.findViewByCountryName(countryName);
    }
}

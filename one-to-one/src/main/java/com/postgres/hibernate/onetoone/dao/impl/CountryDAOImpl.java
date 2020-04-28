package com.postgres.hibernate.onetoone.dao.impl;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.models.DialInDetails;
import com.postgres.hibernate.onetoone.dao.CountryDAO;
import com.postgres.hibernate.onetoone.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CountryDAOImpl implements CountryDAO {

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

		countryRepository.save(india);
		countryRepository.save(usa);
		countryRepository.save(netherlands);


	}

	@Override
	public void getOne() {

		Country country = countryRepository.getOne(1);
		System.out.println("\nCountry is fetched from DB\n");
		System.out.println("Country:: " + country);

		System.out.println("\nDial in details also fetched (Onr-To-One mapping) \n");
		System.out.println("Dial In Details :: " + country.getDialInDetails());
	}

}

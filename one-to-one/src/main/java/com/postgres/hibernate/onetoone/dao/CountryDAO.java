package com.postgres.hibernate.onetoone.dao;

import com.postgres.hibernate.models.Country;

import java.util.List;

public interface CountryDAO {

	List<Country> findAll();

	void save();

	void getOne();

}

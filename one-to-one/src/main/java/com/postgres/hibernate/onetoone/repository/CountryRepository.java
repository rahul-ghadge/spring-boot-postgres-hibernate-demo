package com.postgres.hibernate.onetoone.repository;

import com.postgres.hibernate.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}

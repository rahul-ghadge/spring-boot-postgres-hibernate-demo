package com.postgres.hibernate.onetomany.controller;

import com.postgres.hibernate.onetomany.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.OwnerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OneToManyController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private OwnerVehicleDAO dao;

	@GetMapping("/save-employee-vehicle")
	public void saveOwnerVehicle() {
		LOGGER.info("OneToManyController :: saveOwnerVehicle()");
		dao.saveOwnerVehicle();
	}


	@GetMapping("/")
	public List<OwnerEntity> findAll() {
		LOGGER.info("OneToManyController :: findAll()");
		return dao.findAll();
	}
	
	
	
	@GetMapping("/get-owners")
	public void getOwnerVehicle() {
		LOGGER.info("OneToManyController :: getOwnerVehicle()");
		dao.getOwnerVehicle();
	}


	@GetMapping("/get-keys")
	public void eagerLoading() {
		LOGGER.info("OneToManyController :: eagerLoading()");
		dao.eagerLoadingKeys();
	}
	
	
}

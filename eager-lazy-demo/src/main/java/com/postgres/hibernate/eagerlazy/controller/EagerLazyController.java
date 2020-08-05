package com.postgres.hibernate.eagerlazy.controller;

import com.postgres.hibernate.eagerlazy.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.OwnerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EagerLazyController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OwnerVehicleDAO dao;

	@GetMapping("/save-employee-vehicle")
	public void saveOwnerVehicle() {
		logger.info("EagerLazyController :: saveOwnerVehicle()");
		dao.saveOwnerVehicle();
	}

	
	@GetMapping("/")
	public List<OwnerEntity> findAll() {
		logger.info("EagerLazyController :: findAll()");
		return dao.findAll();
	}
	
	
	
	@GetMapping("/lazy-loading")
	public void lazyLoadingVehicle() {
		logger.info("EagerLazyController :: lazyLoadingVehicle()");
		dao.lazyLoadingVehicle();
	}


	@GetMapping("/eager-loading")
	public void eagerLoading() {
		logger.info("EagerLazyController :: eagerLoading()");
		dao.eagerLoadingKeys();
	}
	
	
}

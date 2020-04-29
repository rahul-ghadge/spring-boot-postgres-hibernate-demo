package com.postgres.hibernate.onetomany.controller;

import com.postgres.hibernate.onetomany.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.OwnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EagerLazyController {
	
	
	@Autowired
	private OwnerVehicleDAO dao;

	@GetMapping("/save-employee-vehicle")
	public void saveOwnerVehicle() {
		dao.saveOwnerVehicle();
	}

	
	@GetMapping("/")
	public List<OwnerEntity> findAll() {
		return dao.findAll();
	}
	
	
	
	@GetMapping("/lazy-loading")
	public void lazyLoadingVehicle() {
		dao.lazyLoadingVehicle();
	}


	@GetMapping("/eager-loading")
	public void eagerLoading() {
		dao.eagerLoadingKeys();
	}
	
	
}

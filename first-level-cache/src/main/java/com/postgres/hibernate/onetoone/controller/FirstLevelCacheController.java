package com.postgres.hibernate.onetoone.controller;

import com.postgres.hibernate.onetoone.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.OwnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirstLevelCacheController {
	
	
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
	
	
	
	@GetMapping("/first-level-cache")
	public void firstLevelCacheOwner() {
		dao.firstLevelCacheOwner();
	}


	@GetMapping("/clear-owner-from-cache")
	public void clearOwnerFromCache() {
		dao.clearOwnerFromCache();
	}


	@GetMapping("/clear-all-from-cache")
	public void clearAllObjectsFromCache() {
		dao.clearAllObjectsFromCache();
	}


}
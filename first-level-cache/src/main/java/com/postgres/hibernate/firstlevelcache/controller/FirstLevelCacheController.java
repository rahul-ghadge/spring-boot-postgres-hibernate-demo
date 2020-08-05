package com.postgres.hibernate.firstlevelcache.controller;

import com.postgres.hibernate.firstlevelcache.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.OwnerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirstLevelCacheController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OwnerVehicleDAO dao;

	@GetMapping("/save-employee-vehicle")
	public void saveOwnerVehicle() {
		logger.info("FirstLevelCacheController :: saveOwnerVehicle()");
		dao.saveOwnerVehicle();
	}

	
	@GetMapping("/")
	public List<OwnerEntity> findAll() {
		logger.info("FirstLevelCacheController :: findAll()");
		return dao.findAll();
	}
	
	
	
	@GetMapping("/first-level-cache")
	public void firstLevelCacheOwner() {
		logger.info("FirstLevelCacheController :: firstLevelCacheOwner()");
		dao.firstLevelCacheOwner();
	}


	@GetMapping("/clear-owner-from-cache")
	public void clearOwnerFromCache() {
		logger.info("FirstLevelCacheController :: clearOwnerFromCache()");
		dao.clearOwnerFromCache();
	}


	@GetMapping("/clear-all-from-cache")
	public void clearAllObjectsFromCache() {
		logger.info("FirstLevelCacheController :: clearAllObjectsFromCache()");
		dao.clearAllObjectsFromCache();
	}


}

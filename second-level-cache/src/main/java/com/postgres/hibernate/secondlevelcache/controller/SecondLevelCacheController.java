package com.postgres.hibernate.secondlevelcache.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.hibernate.models.UserEntity;
import com.postgres.hibernate.secondlevelcache.dao.UserEntityDAO;

@RestController
public class SecondLevelCacheController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserEntityDAO dao;

	@GetMapping("/save-random-user")
	public void saveUser() {
		LOGGER.info("SecondLevelCacheController :: saveUser()");
		dao.saveUser();
	}

	
	@GetMapping("/")
	public List<UserEntity> findAll() {
		LOGGER.info("SecondLevelCacheController :: findAll()");
		return dao.findAll();
	}

	
	@GetMapping("/jpa-cache")
	public void getUserFactoryCache() {
		LOGGER.info("SecondLevelCacheController :: getUserFactoryCache()");
		dao.getUserFactoryCache();
	}


	@GetMapping("/query-cache")
	public void getUserByQuery() {
		LOGGER.info("SecondLevelCacheController :: getUserByQuery()");
		dao.getUserByQuery();
	}
	
	
}

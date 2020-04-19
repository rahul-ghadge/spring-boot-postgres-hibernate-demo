package com.postgres.hibernate.secondlevelcache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.hibernate.entities.secondlevelcache.UserEntity;
import com.postgres.hibernate.secondlevelcache.dao.UserEntityDAO;

@RestController
public class SecondLevelCacheController {
	
	
	@Autowired
	private UserEntityDAO dao;

	@GetMapping("/save-random-user")
	public void saveUser() {
		dao.saveUser();
	}

	
	@GetMapping("/")
	public List<UserEntity> findAll() {
		return dao.findAll();
	}
	
	
	
	@GetMapping("/jpa-repository-cache")
	public void getUserFactoryCache() {
		dao.getUserFactoryCache();
	}


	@GetMapping("/query-cache")
	public void getUserByQuery() {
		dao.getUserByQuery();
	}
	
	
}

package com.postgres.hibernate.manytomany.controller;

import com.postgres.hibernate.manytomany.dao.WhatsAppGroupDAO;
import com.postgres.hibernate.models.WhatsAppGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManyToManyController {
	
	
	@Autowired
	private WhatsAppGroupDAO dao;

	@GetMapping("/save-employee-vehicle")
	public void saveOwnerVehicle() {
		dao.save();
	}

	
	@GetMapping("/")
	public List<WhatsAppGroup> findAll() {
		return dao.findAll();
	}
	
	
	
	@GetMapping("/get-by-id")
	public void getById() {
		dao.getById();
	}
	
}

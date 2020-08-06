package com.postgres.hibernate.manytomany.controller;

import com.postgres.hibernate.manytomany.dao.WhatsAppGroupDAO;
import com.postgres.hibernate.models.WhatsAppGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManyToManyController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private WhatsAppGroupDAO dao;

	@GetMapping("/save-whatsapp-group")
	public void saveWhatsappGroup() {
		LOGGER.info("ManyToManyController :: saveWhatsappGroup()");
		dao.save();
	}

	
	@GetMapping("/")
	public List<WhatsAppGroup> findAll() {
		LOGGER.info("ManyToManyController :: findAll()");
		return dao.findAll();
	}
	
	
	@GetMapping("/get-by-id")
	public void getWhatsappGroupById() {
		LOGGER.info("ManyToManyController :: getWhatsappGroupById()");
		dao.getById();
	}
	
}

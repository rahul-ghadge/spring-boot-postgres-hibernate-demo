package com.postgres.hibernate.eagerlazy;

import java.util.List;

import com.postgres.hibernate.models.OwnerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.hibernate.eagerlazy.dao.OwnerVehicleDAO;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EagerLazyApp {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(EagerLazyApp.class, args);
	}
	
	
	@Autowired
	private OwnerVehicleDAO dao;


	@Bean
	CommandLineRunner runner() {
		return args -> {
			logger.info("Checking for data in DB");
			List<OwnerEntity> list = dao.findAll();

			if (null == list || list.size() < 1) {
				dao.saveOwnerVehicle();
				logger.info("Inserted records in DB");
			} else {
				logger.info("\nList : {}", list);
			}
		};
	}
}

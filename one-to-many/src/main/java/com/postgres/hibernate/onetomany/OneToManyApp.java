package com.postgres.hibernate.onetomany;

import java.util.List;

import com.postgres.hibernate.models.OwnerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.hibernate.onetomany.dao.OwnerVehicleDAO;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToManyApp {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApp.class, args);
	}


	@Autowired
	private OwnerVehicleDAO dao;


	@Bean
	CommandLineRunner runner() {
		return args -> {
			LOGGER.info("Checking for data in DB");
			List<OwnerEntity> list = dao.findAll();

			if (null == list || list.size() < 1) {
				dao.saveOwnerVehicle();
				LOGGER.info("Inserted records in DB");
			} else {
				LOGGER.info("\nList : {}", list);
			}
		};
	}
}

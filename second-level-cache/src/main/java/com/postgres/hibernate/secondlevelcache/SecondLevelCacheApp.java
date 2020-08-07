package com.postgres.hibernate.secondlevelcache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.hibernate.models.UserEntity;
import com.postgres.hibernate.secondlevelcache.dao.UserEntityDAO;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecondLevelCacheApp {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SecondLevelCacheApp.class, args);
	}


	@Autowired
	private UserEntityDAO dao;


	@Bean
	CommandLineRunner runner() {
		return args -> {
			LOGGER.info("Checking for data in DB");
			List<UserEntity> list = dao.findAll();

			if (null == list || list.size() < 5) {
				dao.saveUser();
				LOGGER.info("Inserted some records in DB");
			} else {
				LOGGER.info("\nUser List : {}", list);
			}
		};
	}
}

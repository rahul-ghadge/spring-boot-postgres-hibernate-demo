package com.postgres.hibernate.onetoone;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.onetoone.dao.CountryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class OneToOneApp {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApp.class, args);
	}
	
	
	@Autowired
	private CountryDAO dao;


    @Bean
    CommandLineRunner runner() {
        return args -> {
            LOGGER.info("Checking for data in DB");
            List<Country> list = dao.findAll();

            if (null == list || list.size() < 1) {
                dao.save();
                LOGGER.info("Inserted records in DB");
            } else {
                LOGGER.info("\nList : {}", list);
            }
        };
    }
}

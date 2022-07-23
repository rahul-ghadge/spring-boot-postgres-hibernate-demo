package com.postgres.hibernate.projections;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.projections.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProjectionsApp {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(ProjectionsApp.class, args);
    }

    @Autowired
    private CountryService service;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            LOGGER.info("Checking for data in DB");
            List<Country> list = service.findAll();

            if (null == list || list.size() < 1) {
                service.save();
                LOGGER.info("Inserted records in DB");
            } else {
                LOGGER.info("\nList : {}", list);
            }
        };
    }
}

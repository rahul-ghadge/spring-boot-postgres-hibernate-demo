package com.postgres.hibernate.criteria;

import com.postgres.hibernate.models.Student;
import com.postgres.hibernate.criteria.dao.StudentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CriteriaBuilderApp {

    private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
        SpringApplication.run(CriteriaBuilderApp.class, args);
	}


	@Autowired
	private StudentDAO dao;


    @Bean
    CommandLineRunner runner() {
        return args -> {
            logger.info("Checking for data in DB");
            List<Student> list = dao.findAll();

            if (null == list || list.size() < 1) {
                dao.save();
                logger.info("Inserted records in DB");
            } else {
                logger.info("\nList : {}", list);
            }
        };
    }
}

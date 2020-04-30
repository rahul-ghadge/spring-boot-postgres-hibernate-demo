package com.postgres.hibernate.criteria;

import com.postgres.hibernate.models.Student;
import com.postgres.hibernate.criteria.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CriteriaBuilderApp {


	public static void main(String[] args) {
        SpringApplication.run(CriteriaBuilderApp.class, args);
	}

	
	
	@Autowired
	private StudentDAO dao;


    @Bean
    CommandLineRunner runner() {
        return args -> {
            System.out.println("Checking for data in DB");
            List<Student> list = dao.findAll();

            if (null == list || list.size() < 1) {
                dao.save();
                System.out.println("Inserted records in DB");
            } else {
                System.out.println("\nList :");
                System.out.println(list);
            }
        };
    }
}

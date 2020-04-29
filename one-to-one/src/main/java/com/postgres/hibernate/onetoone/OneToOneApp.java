package com.postgres.hibernate.onetoone;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.onetoone.dao.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class OneToOneApp {


	public static void main(String[] args) {
		SpringApplication.run(OneToOneApp.class, args);
	}

	
	
	@Autowired
	private CountryDAO dao;


    @Bean
    CommandLineRunner runner() {
        return args -> {
            System.out.println("Checking for data in DB");
            List<Country> list = dao.findAll();

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

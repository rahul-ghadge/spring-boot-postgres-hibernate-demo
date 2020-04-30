package com.postgres.hibernate.manytomany;

import java.util.List;

import com.postgres.hibernate.models.WhatsAppGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.hibernate.manytomany.dao.WhatsAppGroupDAO;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManyToManyApp {


	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApp.class, args);
	}


	@Autowired
	private WhatsAppGroupDAO dao;


	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Checking for data in DB");
			List<WhatsAppGroup> list = dao.findAll();

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

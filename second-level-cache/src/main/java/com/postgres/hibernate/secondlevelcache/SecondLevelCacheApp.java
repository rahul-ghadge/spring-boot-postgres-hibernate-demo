package com.postgres.hibernate.secondlevelcache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.hibernate.models.UserEntity;
import com.postgres.hibernate.secondlevelcache.dao.UserEntityDAO;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecondLevelCacheApp {


	public static void main(String[] args) {
		SpringApplication.run(SecondLevelCacheApp.class, args);
	}


	@Autowired
	private UserEntityDAO dao;


	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Checking for data in DB");
			List<UserEntity> userList = dao.findAll();

			if (null == userList || userList.size() < 5) {

				int noOfRecords = (null == userList) ? 0 : userList.size();
				System.out.println("Number of records found in DB: " + noOfRecords);

				dao.saveUser();
				System.out.println("Inserted some records in DB");
			} else {
				System.out.println("\nUser List :");
				System.out.println(userList);
			}
		};
	}
}

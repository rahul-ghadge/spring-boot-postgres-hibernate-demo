package com.postgres.hibernate.secondlevelcache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.hibernate.models.UserEntity;
import com.postgres.hibernate.secondlevelcache.dao.UserEntityDAO;

@SpringBootApplication
public class SecondLevelCacheApp implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SecondLevelCacheApp.class, args);
	}

	
	
	@Autowired
	private UserEntityDAO dao;

	
	@Override
	public void run(String... args) throws Exception {

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
		
		

	}
}

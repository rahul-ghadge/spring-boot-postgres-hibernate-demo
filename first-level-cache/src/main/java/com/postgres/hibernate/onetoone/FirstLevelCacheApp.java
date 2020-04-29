package com.postgres.hibernate.onetoone;

import com.postgres.hibernate.onetoone.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.OwnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;


@SpringBootApplication
//@EntityScan("com.postgres.hibernate.*")
public class FirstLevelCacheApp {


	public static void main(String[] args) {
		SpringApplication.run(FirstLevelCacheApp.class, args);
	}

	
	
	@Autowired
	private OwnerVehicleDAO dao;


	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Checking for data in DB");
			List<OwnerEntity> ownerList = dao.findAll();

			if (null == ownerList || ownerList.size() < 1) {
				dao.saveOwnerVehicle();
				System.out.println("Inserted records in DB");
			} else {
				System.out.println("\nList :");
				System.out.println(ownerList);
			}
		};
	}
}
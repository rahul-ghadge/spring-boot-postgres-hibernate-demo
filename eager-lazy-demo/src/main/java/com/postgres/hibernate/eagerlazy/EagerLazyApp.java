package com.postgres.hibernate.eagerlazy;

import java.util.List;

import com.postgres.hibernate.models.OwnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.postgres.hibernate.eagerlazy.dao.OwnerVehicleDAO;

@SpringBootApplication
public class EagerLazyApp implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(EagerLazyApp.class, args);
	}

	
	
	@Autowired
	private OwnerVehicleDAO dao;

	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Checking for data in DB");
		List<OwnerEntity> ownerList = dao.findAll();

		if (null == ownerList || ownerList.size() < 1) {
			dao.saveOwnerVehicle();
			System.out.println("Inserted records in DB");
		} else {
			System.out.println("\nList :");
			System.out.println(ownerList);
		}
	}
}

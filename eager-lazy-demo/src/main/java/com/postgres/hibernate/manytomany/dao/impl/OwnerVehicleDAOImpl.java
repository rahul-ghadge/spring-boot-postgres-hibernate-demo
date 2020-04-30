package com.postgres.hibernate.manytomany.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.postgres.hibernate.manytomany.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.KeyEntity;
import com.postgres.hibernate.models.OwnerEntity;
import com.postgres.hibernate.models.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postgres.hibernate.manytomany.repository.OwnerRepository;

@Repository
public class OwnerVehicleDAOImpl implements OwnerVehicleDAO {

	@Autowired
	private OwnerRepository ownerRepository;

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<OwnerEntity> findAll() {
		return ownerRepository.findAll();
	}

	
	
	@Override
	public void saveOwnerVehicle() {

		// Add new Employee object
		OwnerEntity owner = new OwnerEntity();
		owner.setEmail("my-user@mail.com");
		owner.setFirstName("my-user");
		owner.setLastName("user");

		VehicleEntity black = new VehicleEntity("MH14DB0011", "Black", 4);
		VehicleEntity silver = new VehicleEntity("MH14AB5555", "Silver", 4);

		owner.addVehicle(black);
		owner.addVehicle(silver);


		KeyEntity blackKey = new KeyEntity("SR0010", "Black");
		KeyEntity silverKey = new KeyEntity("SR0020", "Silver");

		owner.addKey(blackKey);
		owner.addKey(silverKey);

		ownerRepository.save(owner);
	}

	@Override
	public void lazyLoadingVehicle() {
		OwnerEntity emp = ownerRepository.getOne(1);

		System.out.println("Owner:: " + emp);
		System.out.println("\nOnly Owner is fetched from DB\n");
		System.out.println("New Query will be generated for Vehicle");
		System.out.println("\nVehicle get fetched Lazily here from DB\n");
		System.out.println("Vehicles: " + emp.getVehicles());
		System.out.println("Done!");

	}

	@Override
	public void eagerLoadingKeys() {
		OwnerEntity owner = ownerRepository.getOne(1);

		System.out.println("Owner:: " + owner);
		System.out.println("\nOwner is fetched from DB\n");
		System.out.println("No New Query will be generated for Keys");
		System.out.println("\nKeys get fetched Eagerly here from DB\n");
		System.out.println("Keys: " + owner.getKeys());
		System.out.println("Done!");
	}

}

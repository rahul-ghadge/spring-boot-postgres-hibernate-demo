package com.postgres.hibernate.eagerlazy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.postgres.hibernate.eagerlazy.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.KeyEntity;
import com.postgres.hibernate.models.OwnerEntity;
import com.postgres.hibernate.models.VehicleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postgres.hibernate.eagerlazy.repository.OwnerRepository;

@Repository
public class OwnerVehicleDAOImpl implements OwnerVehicleDAO {

	private final Logger logger = LoggerFactory.getLogger(getClass());

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

		logger.info("Saving owner:: {}", owner);

		ownerRepository.save(owner);
	}

	@Override
	public void lazyLoadingVehicle() {
		OwnerEntity owner = ownerRepository.getOne(1);

		logger.info("Owner:: {}", owner);
		logger.info("\nOnly Owner is fetched from DB\n");
		logger.info("New Query will be generated for Vehicle");
		logger.info("\nVehicle get fetched Lazily here from DB\n");
		logger.info("Vehicles: {}", owner.getVehicles());
		logger.info("Done!");

	}

	@Override
	public void eagerLoadingKeys() {
		OwnerEntity owner = ownerRepository.getOne(1);

		logger.info("Owner:: {}", owner);
		logger.info("\nOwner is fetched from DB\n");
		logger.info("No New Query will be generated for Keys");
		logger.info("\nKeys get fetched Eagerly here from DB\n");
		logger.info("Keys: {}", owner.getKeys());
		logger.info("Done!");
	}

}

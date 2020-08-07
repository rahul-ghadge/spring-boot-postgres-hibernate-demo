package com.postgres.hibernate.onetomany.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.postgres.hibernate.onetomany.dao.OwnerVehicleDAO;
import com.postgres.hibernate.models.KeyEntity;
import com.postgres.hibernate.models.OwnerEntity;
import com.postgres.hibernate.models.VehicleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postgres.hibernate.onetomany.repository.OwnerRepository;

@Repository
public class OwnerVehicleDAOImpl implements OwnerVehicleDAO {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

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

		LOGGER.info("Saving owner:: {}", owner);
		ownerRepository.save(owner);
	}

	@Override
	public void getOwnerVehicle() {
		OwnerEntity emp = ownerRepository.getOne(1);

		LOGGER.info("Owner:: {}", emp);
		LOGGER.info("\nOnly Owner is fetched from DB\n");
		LOGGER.info("New Query will be generated for Vehicle");
		LOGGER.info("\nVehicle get fetched Lazily here from DB\n");
		LOGGER.info("Vehicles: {}", emp.getVehicles());
		LOGGER.info("Done!");

	}

	@Override
	public void eagerLoadingKeys() {
		OwnerEntity owner = ownerRepository.getOne(1);

		LOGGER.info("Owner:: {}", owner);
		LOGGER.info("\nOwner is fetched from DB\n");
		LOGGER.info("No New Query will be generated for Keys");
		LOGGER.info("\nKeys get fetched Eagerly here from DB\n");
		LOGGER.info("Keys: {}", owner.getKeys());
		LOGGER.info("Done!");
	}

}

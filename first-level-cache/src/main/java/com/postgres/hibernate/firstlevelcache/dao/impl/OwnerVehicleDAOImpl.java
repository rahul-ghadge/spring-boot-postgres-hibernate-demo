package com.postgres.hibernate.firstlevelcache.dao.impl;

import java.util.List;

import com.postgres.hibernate.firstlevelcache.dao.OwnerVehicleDAO;
import com.postgres.hibernate.firstlevelcache.repository.OwnerRepository;
import com.postgres.hibernate.models.KeyEntity;
import com.postgres.hibernate.models.OwnerEntity;
import com.postgres.hibernate.models.VehicleEntity;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
	public void firstLevelCacheOwner() {

		OwnerEntity owner = ownerRepository.getOne(1);
		logger.info("\nOwner is fetched from DB\n");
		logger.info("Owner:: {}", owner);

		OwnerEntity owner1 = ownerRepository.getOne(1);
		logger.info("\nOwner is fetched from cache\n");
		logger.info("Owner:: {}", owner1);
	}



	@Override
	public void clearOwnerFromCache() {

		// Getting session from entity manager
		Session session = entityManager.unwrap(Session.class);

		OwnerEntity owner = session.find(OwnerEntity.class, 1);
		logger.info("\nOwner is fetched from DB\n");
		logger.info("Owner:: {}", owner);

		// Owner will be removed from session cache (First level cache) so next time it will be loaded from DB
		session.evict(owner);
		logger.info("\nOwner is cleared from cache\n");

		OwnerEntity owner1 = session.find(OwnerEntity.class, 1);
		logger.info("\nOwner is fetched from DB again\n");
		logger.info("Owner:: {}", owner1);
	}



	@Override
	public void clearAllObjectsFromCache() {

		// Getting session from entity manager
		Session session = entityManager.unwrap(Session.class);

		OwnerEntity owner = session.find(OwnerEntity.class, 1);
		logger.info("\nOwner is fetched from DB\n");
		logger.info("Owner:: {}", owner);

		// All objects will be cleared from session cache (First level cache)
		session.clear();
		logger.info("\nOwner is cleared from cache\n");

		OwnerEntity owner1 = session.find(OwnerEntity.class, 1);
		logger.info("\nOwner is fetched from DB again\n");
		logger.info("Owner:: {}", owner1);
	}

}

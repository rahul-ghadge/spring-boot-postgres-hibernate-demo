package com.postgres.hibernate.onetoone.dao.impl;

import java.util.List;

import com.postgres.hibernate.onetoone.dao.OwnerVehicleDAO;
import com.postgres.hibernate.onetoone.repository.OwnerRepository;
import com.postgres.hibernate.models.KeyEntity;
import com.postgres.hibernate.models.OwnerEntity;
import com.postgres.hibernate.models.VehicleEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
	public void firstLevelCacheOwner() {

		OwnerEntity owner = ownerRepository.getOne(1);
		System.out.println("\nOwner is fetched from DB\n");
		System.out.println("Owner:: " + owner);

		OwnerEntity owner1 = ownerRepository.getOne(1);
		System.out.println("\nOwner is fetched from cache\n");
		System.out.println("Owner:: " + owner1);
	}



	@Override
	public void clearOwnerFromCache() {

		// Getting session from entity manager
		Session session = entityManager.unwrap(Session.class);

		OwnerEntity owner = session.find(OwnerEntity.class, 1);
		System.out.println("\nOwner is fetched from DB\n");
		System.out.println("Owner:: " + owner);

		// Owner will be removed from session cache (First level cache) so next time it will be loaded from DB
		session.evict(owner);
		System.out.println("\nOwner is cleared from cache\n");

		OwnerEntity owner1 = session.find(OwnerEntity.class, 1);
		System.out.println("\nOwner is fetched from DB again\n");
		System.out.println("Owner:: " + owner1);
	}



	@Override
	public void clearAllObjectsFromCache() {

		// Getting session from entity manager
		Session session = entityManager.unwrap(Session.class);

		OwnerEntity emp = session.find(OwnerEntity.class, 1);
		System.out.println("\nOwner is fetched from DB\n");
		System.out.println("Owner:: " + emp);

		// All objects will be cleared from session cache (First level cache)
		session.clear();
		System.out.println("\nOwner is cleared from cache\n");

		OwnerEntity emp1 = session.find(OwnerEntity.class, 1);
		System.out.println("\nOwner is fetched from DB again\n");
		System.out.println("Owner:: " + emp1);
	}



}

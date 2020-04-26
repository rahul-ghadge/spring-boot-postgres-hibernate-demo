package com.postgres.hibernate.firstlevelcache.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.postgres.hibernate.firstlevelcache.repository.OwnerRepository;
import com.postgres.hibernate.models.KeyEntity;
import com.postgres.hibernate.models.OwnerEntity;
import com.postgres.hibernate.models.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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

		OwnerEntity emp = ownerRepository.getOne(1);
		System.out.println("\nOwner is fetched from DB\n");
		System.out.println("Owner:: " + emp);

		OwnerEntity emp1 = ownerRepository.getOne(1);
		System.out.println("\nOwner is fetched from cache\n");
		System.out.println("Owner:: " + emp1);
	}



}

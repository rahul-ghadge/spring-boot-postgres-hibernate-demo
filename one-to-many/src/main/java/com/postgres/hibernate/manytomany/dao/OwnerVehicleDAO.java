package com.postgres.hibernate.manytomany.dao;

import com.postgres.hibernate.models.OwnerEntity;

import java.util.List;

public interface OwnerVehicleDAO {

	List<OwnerEntity> findAll();

	void saveOwnerVehicle();

	void getOwnerVehicle();

	void eagerLoadingKeys();
}

package com.postgres.hibernate.onetomany.dao;

import com.postgres.hibernate.models.OwnerEntity;

import java.util.List;

public interface OwnerVehicleDAO {

	List<OwnerEntity> findAll();

	void saveOwnerVehicle();

	void getOwnerVehicle();

	void eagerLoadingKeys();
}

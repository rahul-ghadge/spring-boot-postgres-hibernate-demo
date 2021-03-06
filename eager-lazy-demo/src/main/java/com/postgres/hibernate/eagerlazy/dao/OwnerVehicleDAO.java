package com.postgres.hibernate.eagerlazy.dao;

import com.postgres.hibernate.models.OwnerEntity;

import java.util.List;

public interface OwnerVehicleDAO {

	List<OwnerEntity> findAll();

	void saveOwnerVehicle();

	void lazyLoadingVehicle();

	void eagerLoadingKeys();
}

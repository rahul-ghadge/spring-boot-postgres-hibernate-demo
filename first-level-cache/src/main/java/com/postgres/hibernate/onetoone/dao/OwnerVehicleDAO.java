package com.postgres.hibernate.onetoone.dao;

import com.postgres.hibernate.models.OwnerEntity;

import java.util.List;

public interface OwnerVehicleDAO {

	List<OwnerEntity> findAll();

	void saveOwnerVehicle();

	void firstLevelCacheOwner();

	void clearOwnerFromCache();

	void clearAllObjectsFromCache();

}

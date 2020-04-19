package com.postgres.hibernate.secondlevelcache.dao;

import java.util.List;

import com.postgres.hibernate.entities.secondlevelcache.UserEntity;

public interface UserEntityDAO {

	void saveUser();

	public void getUserFactoryCache();

	public void getUserByQuery();

	List<UserEntity> findAll();
}

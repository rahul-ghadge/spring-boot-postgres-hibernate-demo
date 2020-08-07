package com.postgres.hibernate.secondlevelcache.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.postgres.hibernate.secondlevelcache.dao.UserEntityDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postgres.hibernate.models.UserEntity;
import com.postgres.hibernate.secondlevelcache.repository.UserRepository;

@Repository
public class UserEntityDAOImpl implements UserEntityDAO {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository repo;

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<UserEntity> findAll() {
		return repo.findAll();
	}

	
	
	@Override
	public void saveUser() {

		for (int i = 1; i <= 5; i++) {
			UserEntity emp = new UserEntity();
			emp.setEmail("demo-user" + i + "@mail.com");
			emp.setFirstName("demo-" + i);
			emp.setLastName("user-" + i);

			LOGGER.info("Saving: {}", emp);
			repo.save(emp);
		}
	}

	@Override
	public void getUserFactoryCache() {

		LOGGER.info("Getting data from DB for Id 1 & 2");
		Optional<UserEntity> emp1 = repo.findById(1);
		Optional<UserEntity> emp2 = repo.findById(2);

		LOGGER.info("User 1 : {}", emp1);
		LOGGER.info("User 2 : {}", emp2);

		LOGGER.info("Getting data from Cache for Id 1 & 2");
		Optional<UserEntity> emp11 = repo.findById(1);
		Optional<UserEntity> emp22 = repo.findById(2);

		LOGGER.info("User 1 : {}", emp11);
		LOGGER.info("User 2 : {}", emp22);

	}

	@Override
	public void getUserByQuery() {

		List<UserEntity> emp1 = entityManager
				.createQuery("select u from UserEntity u where u.userId= :id", UserEntity.class)
				.setParameter("id", 1)
				.setHint("org.hibernate.cacheable", true)
				
				.getResultList();


		LOGGER.info("User 1 : {}", emp1);
		LOGGER.info("Closing session");

		LOGGER.info("Getting data from Cache for Id 1");

		List<UserEntity> emp11 = entityManager
				.createQuery("select u from UserEntity u where u.userId= :id", UserEntity.class)
				.setParameter("id", 1)
				.setHint("org.hibernate.cacheable", true)
				
				.getResultList();


		LOGGER.info("User 1 : {}", emp11);

	}

	
}

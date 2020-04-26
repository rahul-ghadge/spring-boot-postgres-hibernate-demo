package com.postgres.hibernate.secondlevelcache.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.postgres.hibernate.secondlevelcache.dao.UserEntityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postgres.hibernate.models.UserEntity;
import com.postgres.hibernate.secondlevelcache.repository.UserRepository;

@Repository
public class UserEntityDAOImpl implements UserEntityDAO {

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

			repo.save(emp);
		}
	}

	@Override
	public void getUserFactoryCache() {

		Optional<UserEntity> emp1 = repo.findById(1);
		Optional<UserEntity> emp2 = repo.findById(2);

		System.out.println(emp1);
		System.out.println(emp2);

		Optional<UserEntity> emp11 = repo.findById(1);
		Optional<UserEntity> emp22 = repo.findById(2);

		System.out.println(emp11);
		System.out.println(emp22);

	}

	@Override
	public void getUserByQuery() {

		List<UserEntity> emp1 = entityManager
				.createQuery("select u from UserEntity u where u.userId= :id", UserEntity.class)
				.setParameter("id", 1)
				.setHint("org.hibernate.cacheable", true)
				
				.getResultList();


		System.out.println(emp1);
		System.out.println("Closing session");
		

		List<UserEntity> emp11 = entityManager
				.createQuery("select u from UserEntity u where u.userId= :id", UserEntity.class)
				.setParameter("id", 1)
				.setHint("org.hibernate.cacheable", true)
				
				.getResultList();
		

		System.out.println(emp11);

	}

	
}

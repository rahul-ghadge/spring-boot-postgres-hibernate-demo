package com.postgres.hibernate.manytomany.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.postgres.hibernate.manytomany.dao.WhatsAppGroupDAO;
import com.postgres.hibernate.models.WhatsAppGroup;
import com.postgres.hibernate.models.WhatsAppGroupAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postgres.hibernate.manytomany.repository.WhatsAppGroupRepository;

@Repository
public class WhatsAppGroupDAOImpl implements WhatsAppGroupDAO {

	@Autowired
	private WhatsAppGroupRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<WhatsAppGroup> findAll() {
		return repository.findAll();
	}

	
	@Transactional
	@Override
	public void save() {

		WhatsAppGroup avengers = new WhatsAppGroup("Avengers", 50, 2020);
		WhatsAppGroup funnyBoys = new WhatsAppGroup("Funny Boys", 100, 2016);
		WhatsAppGroup coding = new WhatsAppGroup("Coding", 500, 2014);

		WhatsAppGroupAdmin superHero = new WhatsAppGroupAdmin("Super Hero");
		WhatsAppGroupAdmin funnyGuy = new WhatsAppGroupAdmin("Funny Guy");
		WhatsAppGroupAdmin coder = new WhatsAppGroupAdmin("Coder");



		avengers.getAdmins().add(superHero);
		avengers.getAdmins().add(coder);

		funnyBoys.getAdmins().add(superHero);
		funnyBoys.getAdmins().add(funnyGuy);

		coding.getAdmins().add(coder);

//		entityManager.persist(avengers);
//		entityManager.persist(funnyBoys);
//		entityManager.persist(coding);

		repository.save(avengers);
		repository.save(funnyBoys);
		repository.save(coding);

	}

	@Override
	public void getById() {
		WhatsAppGroup group = repository.getOne(1);

		System.out.println("WhatsApp Group 1:: " + group);
		System.out.println("\nWhatsApp Group is fetched from DB\n");
		System.out.println("New Query will be generated");
		System.out.println("\nAdmin get fetched Lazily here from DB\n");
		System.out.println("Group Admins: " + group.getAdmins());
		System.out.println("Done!");

		System.out.println("\n\n");

		WhatsAppGroup group2 = entityManager.find(WhatsAppGroup.class, 2);

		System.out.println("WhatsApp Group 2:: " + group2);
		System.out.println("\nWhatsApp Group is fetched from DB\n");
		System.out.println("New Query will be generated");
		System.out.println("\nAdmin get fetched Lazily here from DB\n");
		System.out.println("Group Admins: " + group2.getAdmins());
		System.out.println("Done!");

	}
}

package com.postgres.hibernate.manytomany.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.postgres.hibernate.manytomany.dao.WhatsAppGroupDAO;
import com.postgres.hibernate.models.WhatsAppGroup;
import com.postgres.hibernate.models.WhatsAppGroupAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postgres.hibernate.manytomany.repository.WhatsAppGroupRepository;

@Repository
public class WhatsAppGroupDAOImpl implements WhatsAppGroupDAO {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WhatsAppGroupRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<WhatsAppGroup> findAll() {
		LOGGER.info("Find all whatsapp groups");
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

		LOGGER.info("Saving Whatsapp Group:: {}", avengers);
		repository.save(avengers);
		LOGGER.info("Saving Whatsapp Group:: {}", funnyBoys);
		repository.save(funnyBoys);
		LOGGER.info("Saving Whatsapp Group:: {}", coding);
		repository.save(coding);

	}

	@Override
	public void getById() {
		WhatsAppGroup group = repository.getOne(1);

		LOGGER.info("WhatsApp Group 1:: {}", group);
		LOGGER.info("\nWhatsApp Group is fetched from DB\n");
		LOGGER.info("New Query will be generated");
		LOGGER.info("\nAdmin get fetched Lazily here from DB\n");
		LOGGER.info("Group Admins: {}", group.getAdmins());
		LOGGER.info("Done!");

		LOGGER.info("\n\n");

		WhatsAppGroup group2 = entityManager.find(WhatsAppGroup.class, 2);

		LOGGER.info("WhatsApp Group 2:: {}", group2);
		LOGGER.info("\nWhatsApp Group is fetched from DB\n");
		LOGGER.info("New Query will be generated");
		LOGGER.info("\nAdmin get fetched Lazily here from DB\n");
		LOGGER.info("Group Admins: {}", group2.getAdmins());
		LOGGER.info("Done!");

	}
}

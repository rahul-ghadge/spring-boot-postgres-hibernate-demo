package com.postgres.hibernate.manytomany.dao;

import com.postgres.hibernate.models.WhatsAppGroup;

import java.util.List;

public interface WhatsAppGroupDAO {

	List<WhatsAppGroup> findAll();

	void save();

	void getById();
}

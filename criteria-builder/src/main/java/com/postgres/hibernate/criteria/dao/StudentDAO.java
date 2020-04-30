package com.postgres.hibernate.criteria.dao;

import com.postgres.hibernate.models.Student;

import java.util.List;

public interface StudentDAO {

	List<Student> findAll();

	void save();

	void getOne();

	public void getById();

}

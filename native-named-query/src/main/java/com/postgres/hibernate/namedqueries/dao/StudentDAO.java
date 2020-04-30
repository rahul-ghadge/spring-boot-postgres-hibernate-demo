package com.postgres.hibernate.namedqueries.dao;

import com.postgres.hibernate.models.Student;

import java.util.List;

public interface StudentDAO {

	List<Student> findAll();

	void save();

	void getOne();

	public void getById();

	public void getJPAQueries();

}

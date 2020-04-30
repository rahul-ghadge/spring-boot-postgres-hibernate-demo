package com.postgres.hibernate.namedqueries.dao.impl;

import com.postgres.hibernate.models.Student;
import com.postgres.hibernate.models.utils.QueryUtils;
import com.postgres.hibernate.namedqueries.dao.StudentDAO;
import com.postgres.hibernate.namedqueries.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private StudentRepository repository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }


    @Override
    public void save() {
    	Student aryan = new Student("Aryan", "Ghadage");
    	Student rahul = new Student("Rahul", "Ghadage");
    	Student tabin = new Student("Tabin", "Gautam");

    	repository.save(aryan);
    	repository.save(rahul);
    	repository.save(tabin);

    }

    @Override
    public void getOne() {

        System.out.println("Getting Student by name");
        List<Student> list = entityManager
                .createNamedQuery(QueryUtils.STUDENT_BY_NAME_IDENTIFIER, Student.class)
                .setParameter("firstName", "Aryan")
                .getResultList();
		System.out.println("Student :: " + list);

    }

    @Override
    public void getById() {

		System.out.println("Getting student by Id with Named query");
        List<Student> list = entityManager
                .createNamedQuery(QueryUtils.STUDENT_BY_ID_IDENTIFIER, Student.class)
                .setParameter("id", 1)
                .getResultList();

        System.out.println(list);

		System.out.println("\n *******************************************\n");

		System.out.println("Getting student by last name with Native sql query");

		List<Student> list1 = entityManager
				.createNamedQuery(QueryUtils.STUDENT_BY_LAST_NAME_IDENTIFIER)
				.setParameter(1, "Ghadage")
				.getResultList();

		System.out.println(list1);
	}

    @Override
	public void getJPAQueries() {

        List<Student> studentListHql = repository.getAllStudentByHQL();
        System.out.println("Student HQL :: " + studentListHql);

        System.out.println("\n");

        List<Student> nativeStudentListByIdByIndex = repository.getNativeStudentByIdByIndex(1);
        System.out.println("Student List by index param in query :: " + nativeStudentListByIdByIndex);

        System.out.println("\n");

        Student studentHqlByParams = repository.getStudentByFirstNameAndLastName("Aryan", "Ghadage");
        System.out.println("Student List By First name & Last name :: " + studentHqlByParams);



    }
}

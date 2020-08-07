package com.postgres.hibernate.namedqueries.dao.impl;

import com.postgres.hibernate.models.Student;
import com.postgres.hibernate.models.utils.QueryUtils;
import com.postgres.hibernate.namedqueries.dao.StudentDAO;
import com.postgres.hibernate.namedqueries.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    
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

        LOGGER.info("Saving :: {}", aryan);
        repository.save(aryan);
        LOGGER.info("Saving :: {}", rahul);
        repository.save(rahul);
        LOGGER.info("Saving :: {}", tabin);
        repository.save(tabin);

    }

    @Override
    public void getOne() {

        LOGGER.info("Getting Student by name");
        List<Student> list = entityManager
                .createNamedQuery(QueryUtils.STUDENT_BY_NAME_IDENTIFIER, Student.class)
                .setParameter("firstName", "Aryan")
                .getResultList();
        LOGGER.info("Student :: {}", list);

    }

    @Override
    public void getById() {

        LOGGER.info("Getting student by Id with Named query");
        List<Student> list = entityManager
                .createNamedQuery(QueryUtils.STUDENT_BY_ID_IDENTIFIER, Student.class)
                .setParameter("id", 1)
                .getResultList();

        LOGGER.info("Students :: {}", list);

        LOGGER.info("*******************************************");

        LOGGER.info("Getting student by last name with Native sql query");

        List<Student> list1 = entityManager
                .createNamedQuery(QueryUtils.STUDENT_BY_LAST_NAME_IDENTIFIER, Student.class)
                .setParameter(1, "Ghadage")
                .getResultList();

        LOGGER.info("Students :: {}", list1);
    }

    @Override
    public void getJPAQueries() {

        List<Student> studentListHql = repository.getAllStudentByHQL();
        LOGGER.info("Student HQL :: {}", studentListHql);

        LOGGER.info("\n");

        List<Student> nativeStudentListByIdByIndex = repository.getNativeStudentByIdByIndex(1);
        LOGGER.info("Student List by index param in query :: {}", nativeStudentListByIdByIndex);

        LOGGER.info("\n");

        Student studentHqlByParams = repository.getStudentByFirstNameAndLastName("Aryan", "Ghadage");
        LOGGER.info("Student List By First name & Last name :: {}", studentHqlByParams);


    }
}

package com.postgres.hibernate.criteria.dao.impl;

import com.postgres.hibernate.criteria.dao.StudentDAO;
import com.postgres.hibernate.criteria.repository.StudentRepository;
import com.postgres.hibernate.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentRepository repository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Student> findAll() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteria.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

        List<Student> list = query.getResultList();

        logger.info("Getting all Students using criteria builder");
        logger.info("Student :: {}", list);

        return list;
    }


    @Override
    public void save() {
        Student aryan = new Student("Aryan", "Ghadage");
        Student rahul = new Student("Rahul", "Ghadage");
        Student tabin = new Student("Tabin", "Gautam");

        logger.info("Saving  :: {}", aryan);
        repository.save(aryan);
        logger.info("Saving  :: {}", rahul);
        repository.save(rahul);
        logger.info("Saving  :: {}", tabin);
        repository.save(tabin);


    }

    @Override
    public List<Student> getOne() {

        List<Predicate> andCriteria = new ArrayList<>();


        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteria.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        andCriteria.add(criteria.equal(root.get("firstName"), "Aryan"));
        andCriteria.add(criteria.like(root.get("lastName"), "%Ghadage%"));

        Predicate[] predicates = new Predicate[andCriteria.size()];
        predicates = andCriteria.toArray(predicates);
        criteriaQuery.where(predicates);

        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

        List<Student> list = query.getResultList();

        logger.info("Getting Student by first name and last name using criteria builder");
        logger.info("Student :: {}", list);

        return list;
    }

    @Override
    public List<Student> getById() {


        logger.info("Getting student by Id > 0 with Criteria Builder");
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteria.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        criteriaQuery.where(criteria.gt(root.get("studentId"), 0));
        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

        List<Student> list = query.getResultList();

        logger.info("Getting Student by Id using criteria builder");
        logger.info("Student :: {}", list);

        return list;
    }
}

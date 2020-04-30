package com.postgres.hibernate.criteria.dao.impl;

import com.postgres.hibernate.criteria.dao.StudentDAO;
import com.postgres.hibernate.criteria.repository.StudentRepository;
import com.postgres.hibernate.models.Student;
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

    @Autowired
    private StudentRepository repository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Student> findAll() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteria.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        return entityManager.createQuery(criteriaQuery).getResultList();
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

        System.out.println("Getting Student by first name and last name using criteria builder");
        System.out.println("Student :: " + list);

    }

    @Override
    public void getById() {


        System.out.println("Getting student by Id > 0 with Criteria Builder");
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteria.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        criteriaQuery.where(criteria.gt(root.get("studentId"), 0));
        TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);

        List<Student> list = query.getResultList();

        System.out.println("Student :: " + list);
    }
}

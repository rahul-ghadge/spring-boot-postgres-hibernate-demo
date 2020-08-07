package com.postgres.hibernate.namedqueries.controller;

import com.postgres.hibernate.models.Student;
import com.postgres.hibernate.namedqueries.dao.StudentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    public class StudentController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentDAO dao;

    @GetMapping("/save")
    public void save() {
        LOGGER.info("StudentController::save() - Saving all students");
        dao.save();
    }


    @GetMapping("/")
    public List<Student> findAll() {
        LOGGER.info("StudentController::findAll() - Get all students");
        List<Student> list  = dao.findAll();
        //list.forEach(System.out::println);
        LOGGER.info("StudentController::findAll() - All students : {}", list);
        return list;
    }


    @GetMapping("/get-one")
    public void getOne() {
        LOGGER.info("StudentController::getOne() - Get one student");
        dao.getOne();
    }


    @GetMapping("/get-by-id")
    public void getById() {
        LOGGER.info("StudentController::getOne() - Get one student");
        dao.getById();
    }


    @GetMapping("/get-jpa-queries")
    public void getJPAQueries() {
        LOGGER.info("StudentController::getJPAQueries() - Get one student");
        dao.getJPAQueries();
    }

}

package com.postgres.hibernate.criteria.controller;

import com.postgres.hibernate.models.Student;
import com.postgres.hibernate.criteria.dao.StudentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentDAO dao;

    @GetMapping("/save")
    public void save() {
        logger.info("StudentController::save() - Saving all students");
        dao.save();
    }


    @GetMapping("/")
    public List<Student> findAll() {
        logger.info("StudentController::findAll() - Get all students");
        List<Student> list  = dao.findAll();
        //list.forEach(System.out::println);
        logger.info("StudentController::findAll() - All students : {}", list);
        return list;
    }


    @GetMapping("/get-one")
    public List<Student> getOne() {
        logger.info("StudentController::getOne() - Get one student");
        List<Student> list  = dao.getOne();
        logger.info("StudentController::getOne() - Get one student : {}", list);
        return list;
    }


    @GetMapping("/get-by-id")
    public List<Student> getById() {
        return dao.getById();
    }

}

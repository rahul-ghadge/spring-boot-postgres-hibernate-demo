package com.postgres.hibernate.criteria.controller;

import com.postgres.hibernate.models.Student;
import com.postgres.hibernate.criteria.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentDAO dao;

    @GetMapping("/save")
    public void save() {
        dao.save();
    }


    @GetMapping("/")
    public List<Student> findAll() {
        List<Student> list  = dao.findAll();
        System.out.println("\n");
        list.forEach(System.out::println);
        return list;
    }


    @GetMapping("/get-one")
    public void getOne() {
        dao.getOne();
    }


    @GetMapping("/get-by-id")
    public void getById() {
        dao.getById();
    }

}

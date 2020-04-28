package com.postgres.hibernate.onetoone.controller;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.onetoone.dao.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OneToOneController {


    @Autowired
    private CountryDAO dao;

    @GetMapping("/save-country")
    public void save() {
        dao.save();
    }


    @GetMapping("/")
    public void findAll() {
        List<Country> list  = dao.findAll();
        System.out.println("\n");
        list.forEach(System.out::println);
    }


    @GetMapping("/get-one")
    public void getOne() {
        dao.getOne();
    }

}

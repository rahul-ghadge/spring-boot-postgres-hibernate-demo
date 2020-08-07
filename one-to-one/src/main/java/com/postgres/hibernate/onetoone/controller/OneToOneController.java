package com.postgres.hibernate.onetoone.controller;

import com.postgres.hibernate.models.Country;
import com.postgres.hibernate.onetoone.dao.CountryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OneToOneController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private CountryDAO dao;

    @GetMapping("/save-country")
    public void save() {
        LOGGER.info("OneToOneController :: save()");
        dao.save();
    }


    @GetMapping("/")
    public void findAll() {
        LOGGER.info("OneToManyController :: findAll()");
        List<Country> list  = dao.findAll();
        System.out.println("\n");
        list.forEach(System.out::println);
        LOGGER.info("OneToManyController :: Country details :: {}", list);

    }


    @GetMapping("/get-one")
    public void getOne() {
        LOGGER.info("OneToManyController :: getOne()");
        dao.getOne();
    }

    @GetMapping("/get-by-id")
    public void getCountryById() {
        LOGGER.info("OneToManyController :: getCountryById()");
        dao.getCountryById();
    }

}

package com.postgres.hibernate.projections.controller;

import com.postgres.hibernate.projections.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/projections")
public class ProjectionsController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/dto/{countryName}")
    public ResponseEntity<?> findByCountryName(@PathVariable String countryName) {
        return ResponseEntity.ok(countryService.findByCountryName(countryName));
    }

    @GetMapping("/country/object/array/{countryName}")
    public ResponseEntity<?> getCountryDetails(@PathVariable String countryName) {
        return ResponseEntity.ok(countryService.getCountryDetails(countryName));
    }

    @GetMapping("/country/constructor/{countryName}")
    public ResponseEntity<?> findByCountryNameConstructor(@PathVariable String countryName) {
        return ResponseEntity.ok(countryService.findByCountryNameConstructor(countryName));
    }

    @GetMapping("/country/view/interface/{countryName}")
    public ResponseEntity<?> findViewByCountryName(@PathVariable String countryName) {
        return ResponseEntity.ok(countryService.findViewByCountryName(countryName));
    }
}

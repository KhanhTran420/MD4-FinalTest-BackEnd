package com.example.testfinal.controller;

import com.example.testfinal.model.Country;
import com.example.testfinal.service.city.ICityService;
import com.example.testfinal.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
public class CountryController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @GetMapping
    public ResponseEntity<Iterable<Country>> allCountry(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> saveCate(@RequestBody Country country){
        countryService.save(country);
        return new ResponseEntity<>(country,HttpStatus.CREATED);
    }

}

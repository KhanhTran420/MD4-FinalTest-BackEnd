package com.example.testfinal.controller;

import com.example.testfinal.model.City;
import com.example.testfinal.model.Country;
import com.example.testfinal.service.city.ICityService;
import com.example.testfinal.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class CityController {

    @Autowired
    ICityService cityService;

    @Autowired
    ICountryService countryService;

    @ModelAttribute("country")
    public Iterable<Country> listAllCountry(){
        return countryService.findAll();
    }

        @GetMapping
    public ResponseEntity<Iterable<City>> listCity() {
//        List<Transcript> bookList = (List<Transcript>) transcriptService.findAll();
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/countries")
    public ResponseEntity<Iterable<Country>> allCountry(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{id}")
    public ResponseEntity<City> findOne(@PathVariable Long id) {
        City city = cityService.findById(id).get();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}

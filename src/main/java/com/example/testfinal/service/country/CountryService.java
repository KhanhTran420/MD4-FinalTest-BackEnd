package com.example.testfinal.service.country;

import com.example.testfinal.model.Country;
import com.example.testfinal.ripository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryService implements ICountryService{

    @Autowired
    ICountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
       countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
      countryRepository.deleteById(id);
    }
}

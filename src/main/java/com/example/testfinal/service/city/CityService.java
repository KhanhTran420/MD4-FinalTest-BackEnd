package com.example.testfinal.service.city;

import com.example.testfinal.model.City;
import com.example.testfinal.model.Country;
import com.example.testfinal.ripository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService{

    @Autowired
    private ICityRepository cityRepository;


    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
       cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Iterable<City> findAllByCategory(Country country) {
        return null;
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<City> findAllByNameContaining(String name, Pageable pageable) {
        return null;
    }
}

package com.example.testfinal.service.city;

import com.example.testfinal.model.City;
import com.example.testfinal.model.Country;
import com.example.testfinal.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IGeneralService<City> {
    Iterable<City> findAllByCategory(Country country);
    Page<City> findAll(Pageable pageable);
    Page<City> findAllByNameContaining(String name, Pageable pageable);
}

package com.example.testfinal.ripository;

import com.example.testfinal.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City,Long> {
}

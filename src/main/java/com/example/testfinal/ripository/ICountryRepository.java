package com.example.testfinal.ripository;

import com.example.testfinal.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country,Long> {
}

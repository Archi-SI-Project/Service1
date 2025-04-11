package com.example.demo.repository;

import com.example.demo.persistance.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}

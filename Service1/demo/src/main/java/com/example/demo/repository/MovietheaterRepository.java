package com.example.demo.repository;

import com.example.demo.persistance.City;
import com.example.demo.persistance.Movietheater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovietheaterRepository extends JpaRepository<Movietheater, Integer> {
}

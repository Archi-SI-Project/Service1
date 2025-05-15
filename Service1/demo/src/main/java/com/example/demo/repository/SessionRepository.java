package com.example.demo.repository;

import com.example.demo.persistance.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    List<Session> findByIdMovie_Id(Integer movieId);
}

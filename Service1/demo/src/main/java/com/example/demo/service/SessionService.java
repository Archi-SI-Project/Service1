package com.example.demo.service;

import com.example.demo.persistance.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionById(int id) {
        return sessionRepository.findById(id).orElse(null);
    }

}

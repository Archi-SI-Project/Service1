package com.example.demo.controllers;


import com.example.demo.persistance.Session;
import com.example.demo.service.SessionService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    private final SessionService sessionService;
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    @Transactional
    @GetMapping()
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @Transactional
    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable int id) {
        return sessionService.getSessionById(id);
    }

}

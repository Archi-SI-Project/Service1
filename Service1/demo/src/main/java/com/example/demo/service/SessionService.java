package com.example.demo.service;

import com.example.demo.DTO.SessionDTO;
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

    // Retourne une liste de DTOs
    public List<SessionDTO> getAllSessions() {
        return sessionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Retourne un seul DTO
    public SessionDTO getSessionById(int id) {
        return sessionRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public SessionDTO getSessionByMovieId(int movieId) {
        Session session = sessionRepository.findByIdMovie_Id(movieId);
        return session != null ? convertToDTO(session) : null;
    }

    // Méthode pour convertir une entité vers un DTO
    private SessionDTO convertToDTO(Session session) {
        SessionDTO dto = new SessionDTO();
        dto.setId(session.getId() != null ? session.getId().longValue() : null);
        dto.setStartingTime(session.getStartingTime() != null ? session.getStartingTime().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime() : null);
        dto.setEndingTime(session.getEndingTime() != null ? session.getEndingTime().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime() : null);
        dto.setIdMovie(session.getIdMovie() != null ? session.getIdMovie().getId().longValue() : null);
        dto.setIdMovieTheater(session.getIdMovieTheater() != null ? session.getIdMovieTheater().getId().longValue() : null);
        return dto;
    }
}


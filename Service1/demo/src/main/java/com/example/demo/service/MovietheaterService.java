package com.example.demo.service;

import com.example.demo.persistance.Movietheater;
import com.example.demo.repository.MovietheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovietheaterService {
    private final MovietheaterRepository movietheaterRepository;
    public MovietheaterService(MovietheaterRepository movietheaterRepository) {
        this.movietheaterRepository = movietheaterRepository;
    }
    public List<Movietheater> getAllMovietheaters() {
        return movietheaterRepository.findAll();
    }
}

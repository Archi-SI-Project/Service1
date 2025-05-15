package com.example.demo.service;


import com.example.demo.persistance.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> filterMovies(
            String genre,
            Integer minDuration,
            Integer maxDuration,
            LocalDate minCreationDate,
            LocalDate maxCreationDate,
            String searchTerm,
            String city,
            String sessionDate
    ) {
        return movieRepository.searchMovies(genre, minDuration, maxDuration, minCreationDate, maxCreationDate, searchTerm, city, sessionDate);
    }


}

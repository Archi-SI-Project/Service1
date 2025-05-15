package com.example.demo.repository;

import com.example.demo.persistance.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepositoryCustom {
    List<Movie> searchMovies(
            String genre,
            Integer minDuration,
            Integer maxDuration,
            LocalDate minCreationDate,
            LocalDate maxCreationDate,
            String searchTerm,
            String city,
            String sessionDate
    );
}

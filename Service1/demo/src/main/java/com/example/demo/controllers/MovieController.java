package com.example.demo.controllers;

import com.example.demo.persistance.Movie;
import com.example.demo.service.MovieService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;

    }
    @GetMapping()
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public Movie getMovieById( @PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/search")
    public List<Movie> searchMovies(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer minDuration,
            @RequestParam(required = false) Integer maxDuration,
            @RequestParam(required = false) String minCreationDate,
            @RequestParam(required = false) String maxCreationDate,
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String sessionDate
    ) {
        LocalDate minCreationFullDate = null;
        LocalDate maxCreationFullDate = null;

        if (minCreationDate != null) {
            int year = Integer.parseInt(minCreationDate);
            minCreationFullDate = LocalDate.of(year, 1, 1); // 1er janvier
        }

        if (maxCreationDate != null) {
            int year = Integer.parseInt(maxCreationDate);
            maxCreationFullDate = LocalDate.of(year, 12, 31); // 31 décembre
        }
        System.out.println("genre: " + genre + ", minDuration: " + minDuration + ", maxDuration: " + maxDuration + ", minCreationDate: " + minCreationDate + ", maxCreationDate: " + maxCreationDate + ", searchTerm: " + searchTerm + ", city: " + city + ", sessionDate: " + sessionDate);
        return movieService.filterMovies(genre, minDuration, maxDuration, minCreationFullDate, maxCreationFullDate, searchTerm, city, sessionDate);
    }


}

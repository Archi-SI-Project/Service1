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
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate minCreationDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate maxCreationDate,
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String city
    ) {

        return movieService.filterMovies(genre, minDuration, maxDuration, minCreationDate, maxCreationDate, searchTerm, city);
    }


}

package com.example.demo.controllers;

import com.example.demo.persistance.Movietheater;
import com.example.demo.service.MovietheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movietheaters")
public class MovietheatersController {

    private final MovietheaterService movietheaterService;

    public MovietheatersController(MovietheaterService movietheaterService) {
        this.movietheaterService = movietheaterService;
    }
    @GetMapping()
    public List<Movietheater> getAllMovietheaters() {
        return movietheaterService.getAllMovietheaters();
    }
}

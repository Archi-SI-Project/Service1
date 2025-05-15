package com.example.demo.DTO;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SessionDTO {
    private Long id;
    private LocalDateTime startingTime;
    private LocalDateTime endingTime;
    private Long idMovie;
    private Long idMovieTheater;
}
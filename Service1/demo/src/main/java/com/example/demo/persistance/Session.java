package com.example.demo.persistance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "session_instance", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_id_gen")
    @SequenceGenerator(name = "session_id_gen", sequenceName = "session_id_session_seq", allocationSize = 1)
    @Column(name = "id_session", nullable = false)
    private Integer id;

    @Column(name = "starting_time", nullable = false)
    private Instant startingTime;

    @Column(name = "ending_time", nullable = false)
    private Instant endingTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_movie", nullable = false)
    private Movie idMovie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_movie_theater", nullable = false)
    private Movietheater idMovieTheater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Instant startingTime) {
        this.startingTime = startingTime;
    }

    public Instant getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Instant endingTime) {
        this.endingTime = endingTime;
    }

    public Movie getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Movie idMovie) {
        this.idMovie = idMovie;
    }

    public Movietheater getIdMovieTheater() {
        return idMovieTheater;
    }

    public void setIdMovieTheater(Movietheater idMovieTheater) {
        this.idMovieTheater = idMovieTheater;
    }

}
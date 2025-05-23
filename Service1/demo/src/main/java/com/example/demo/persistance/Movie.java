package com.example.demo.persistance;

import com.example.demo.enums.LanguageEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "movie", schema = "public")
public class Movie {
    @Id
    @ColumnDefault("nextval('movie_id_movie_seq')")
    @Column(name = "id_movie", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "director", length = 100)
    private String director;

    @Column(name = "image")
    private String image;

    @Column(name = "main_actors", length = Integer.MAX_VALUE)
    private String mainActors;
    @Column(name = "synopsis", length = Integer.MAX_VALUE)
    private String synopsis;

    @Column(name = "min_age")
    private Short minAge;

    @Column(name = "genre", length = 50)
    private String genre;
    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private LanguageEnum.SubtitleEnum language;

    @Column(name = "subtitle_language")
    @Enumerated(EnumType.STRING)
    private LanguageEnum.SubtitleEnum subtitleLanguage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMainActors() {
        return mainActors;
    }

    public void setMainActors(String mainActors) {
        this.mainActors = mainActors;
    }

    public Short getMinAge() {
        return minAge;
    }

    public void setMinAge(Short minAge) {
        this.minAge = minAge;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public LanguageEnum.SubtitleEnum getLanguage() {
        return language;
    }
    public void setLanguage(LanguageEnum.SubtitleEnum language) {
        this.language = language;
    }
    public LanguageEnum.SubtitleEnum getSubtitleLanguage() {
        return subtitleLanguage;
    }
    public void setSubtitleLanguage(LanguageEnum.SubtitleEnum subtitleLanguage) {
        this.subtitleLanguage = subtitleLanguage;
    }

}
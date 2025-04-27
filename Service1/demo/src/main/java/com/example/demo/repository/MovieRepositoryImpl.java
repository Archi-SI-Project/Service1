package com.example.demo.repository;

import com.example.demo.persistance.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Movie> searchMovies(String genre, Integer minDuration, Integer maxDuration, LocalDate minCreationDate, LocalDate maxCreationDate, String searchTerm, String city, String sessionDate) {
        // System.out.println("genre: " + genre + ", minDuration: " + minDuration + ", maxDuration: " + maxDuration + ", minCreationDate: " + minCreationDate + ", maxCreationDate: " + maxCreationDate + ", searchTerm: " + searchTerm + ", city: " + city + ", sessionDate: " + sessionDate);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT m.* ");
        sql.append("FROM movie m ");
        sql.append("JOIN session_instance s ON s.id_movie = m.id_movie ");
        sql.append("JOIN movietheater mt ON s.id_movie_theater = mt.id_movie_theater ");
        sql.append("JOIN city c ON mt.city_id = c.id_city ");
        sql.append("WHERE 1=1 ");

        if (genre != null) {
            sql.append("AND LOWER(m.genre) = LOWER(:genre) ");
        }
        if (minDuration != null) {
            sql.append("AND m.duration >= :minDuration ");
        }
        if (maxDuration != null) {
            sql.append("AND m.duration <= :maxDuration ");
        }
        if (minCreationDate != null) {
            sql.append("AND m.creation_date >= :minCreationDate ");
        }
        if (maxCreationDate != null) {
            sql.append("AND m.creation_date <= :maxCreationDate ");
        }
        if (searchTerm != null) {
            sql.append("AND (LOWER(m.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) ");
            sql.append("OR LOWER(m.synopsis) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) ");
        }
        if (city != null) {
            sql.append("AND (LOWER(c.name) LIKE LOWER(:city) OR c.zip_code = :city) ");
        }
        if (sessionDate != null) {
            if (sessionDate.equalsIgnoreCase("past")) {
                sql.append("AND CURRENT_DATE > s.ending_date ");
            } else if (sessionDate.equalsIgnoreCase("current")) {
                sql.append("AND CURRENT_DATE BETWEEN s.starting_date AND s.ending_date ");
            } else if (sessionDate.equalsIgnoreCase("upcoming")) {
                sql.append("AND CURRENT_DATE < s.starting_date ");
            }
        }

        System.out.println(sql.toString());

        Query query = entityManager.createNativeQuery(sql.toString(), Movie.class);

        if (genre != null) query.setParameter("genre", genre);
        if (minDuration != null) query.setParameter("minDuration", minDuration);
        if (maxDuration != null) query.setParameter("maxDuration", maxDuration);
        if (minCreationDate != null) query.setParameter("minCreationDate", minCreationDate);
        if (maxCreationDate != null) query.setParameter("maxCreationDate", maxCreationDate);
        if (searchTerm != null) query.setParameter("searchTerm", searchTerm);
        if (city != null) query.setParameter("city", city);
        if (sessionDate != null) query.setParameter("sessionDate", sessionDate);

        return query.getResultList();
    }
}



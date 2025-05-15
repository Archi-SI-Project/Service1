package com.example.demo.persistance;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "movietheater", schema = "public")
public class Movietheater {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movietheater_id_gen")
    @SequenceGenerator(name = "movietheater_id_gen", sequenceName = "movietheater_id_movie_theater_seq", allocationSize = 1)
    @Column(name = "id_movie_theater", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "city_id")
    City city;

    @Column(name = "address", nullable = false, length = Integer.MAX_VALUE)
    private String address;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
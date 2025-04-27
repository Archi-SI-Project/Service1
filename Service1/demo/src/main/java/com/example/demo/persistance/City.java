package com.example.demo.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "city", schema = "public")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_id_gen")
    @SequenceGenerator(name = "city_id_gen", sequenceName = "city_id_city_seq", allocationSize = 1)
    @Column(name = "id_city", nullable = false)
    private Integer id;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
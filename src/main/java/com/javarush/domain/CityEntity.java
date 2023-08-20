package com.javarush.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema="world", name="city")
@Getter
@Setter
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(name = "district")
    private String district;

    @Column(name = "population")
    private Integer population;

}

package com.example.FlightSearchAPI.Airports;

import jakarta.persistence.*;

@Entity
@Table
public class Airport {
    @Id
    @SequenceGenerator(
            name = "airport_sequence",
            sequenceName =  "airport_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "airport_sequence"
    )

    private Long Id;
    private String city;

    public Airport() {
    }

    public Airport(String city) {
        this.city = city;
    }

    public Airport(Long id, String city) {
        Id = id;
        this.city = city;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Id=" + Id +
                ", city='" + city + '\'' +
                '}';
    }
}

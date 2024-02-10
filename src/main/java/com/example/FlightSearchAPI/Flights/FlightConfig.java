package com.example.FlightSearchAPI.Flights;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;


@Configuration
public class FlightConfig {
    @Bean
    CommandLineRunner commandLineRunner(FlightRepository repository){
        return args -> {
            Flight flight1 = new Flight(
                    "Dallas Fort Worth",
                    "flight1@gmail.com",
                    "Los Angeles",
                    LocalDateTime.of(2019, 3, 28, 14, 33, 48, 49),
                    LocalDateTime.of(2019, 3, 30, 17, 45, 48, 56),
                    55.12);

            Flight flight2 = new Flight(
                    "Toronto Pearson",
                    "flight2@gmail.com",
                    "Miami",
                    LocalDateTime.of(2023, 3, 28, 14, 33, 48, 32),
                    LocalDateTime.of(2023, 4, 5, 8, 25, 14, 17),
                    LocalDateTime.of(2023, 11, 6, 7, 25, 55, 23),
                    113.45);


            repository.saveAll(
                    List.of(flight1,flight2)
            );

        };

    }
}

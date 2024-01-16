package com.example.FlightSearchAPI.Airports;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AirportConfig {

    @Bean
    CommandLineRunner AirportcommandLineRunner(AirportRepository repository){
        return args -> {
            Airport airport1 = new Airport(
                    "Istanbul"
            );
            Airport airport2 = new Airport(
                    "Ankara"
            );

            repository.saveAll(List.of(airport1,airport2));

        };

    }



}

package com.example.FlightSearchAPI.Airports;

import com.example.FlightSearchAPI.Flights.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AirportRepository  extends JpaRepository<Airport,Long> {
    @Query("SELECT s FROM Airport s WHERE s.city = ?1")
    Optional<Airport> findAirportByCity(String city);


    @Query("SELECT s FROM Airport s WHERE s.Id = ?1")
    Optional<Airport> findAllById(Long airportId);
}

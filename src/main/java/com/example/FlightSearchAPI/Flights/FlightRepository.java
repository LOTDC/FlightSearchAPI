package com.example.FlightSearchAPI.Flights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    @Query("SELECT s FROM Flight s WHERE s.email = ?1")
    Optional<Flight> findFlightByEmail(String email);

    @Query("SELECT s FROM Flight s WHERE s.ID = ?1")
    Optional<Flight> findAllById(Long flightId);
}

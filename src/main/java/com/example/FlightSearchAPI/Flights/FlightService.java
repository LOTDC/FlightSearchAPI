package com.example.FlightSearchAPI.Flights;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService (FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }
    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }


    public void addNewFlight(Flight flight) throws IllegalAccessException {
        Optional<Flight> flightByEmail = flightRepository.findFlightByEmail(flight.getEmail());
        if(flightByEmail.isPresent()){
            throw new IllegalAccessException("email taken");
        }
        flightRepository.save(flight);

    }

    public void deleteFlight(Long flightid) throws IllegalAccessException {
        boolean exists = flightRepository.existsById(flightid);
        if(!exists){
            throw new IllegalAccessException("flight with id " + flightid + " does not exists");
        }
        flightRepository.deleteById(flightid);
    }

    @Transactional
    public void updateFlight(Long flightId, String departure, String email) {

        Flight flight = flightRepository.findAllById(flightId).orElseThrow(()-> new IllegalStateException("Flight with id " + flightId + " does not exists"));

        if(departure != null && departure.length()>0 && !Objects.equals(flight.getDeparture(),departure)){
            flight.setDeparture(departure);
        }

        if(email != null && email.length() >0 && !Objects.equals(flight.getEmail(),email)){
            Optional<Flight> flightOptional = flightRepository.findFlightByEmail(email);
            if(flightOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            flight.setEmail(email);
        }


    }
}
















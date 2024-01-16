package com.example.FlightSearchAPI.Airports;

import com.example.FlightSearchAPI.Flights.Flight;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;
    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAirpot(){
        return airportRepository.findAll();
    }

    public void addNewAirport(Airport airport) {
        Optional <Airport> airportOptional = airportRepository.findAirportByCity(airport.getCity());
        if(airportOptional.isPresent()){
            throw new IllegalStateException("The airport already exist");
        }
        airportRepository.save(airport);
    }


    public void deleteAirport(Long airportId) {
           boolean exists = airportRepository.existsById(airportId);
           if(!exists){
               throw new IllegalStateException("Airport with id " + airportId + " does not exists");
           }
           airportRepository.deleteById(airportId);
    }

    @Transactional
    public void updateAirport(Long airportId, String city) {
        Airport airport = airportRepository.findAllById(airportId).orElseThrow(() -> new IllegalStateException("Airport with id " + airportId + " does not exist"));


        if(city != null && city.length() >0 && !Objects.equals(airport.getCity(),city)){
            Optional<Airport> airportOptional = airportRepository.findAirportByCity(city);
            if(airportOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            airport.setCity(city);
        }

    }



}















package com.example.FlightSearchAPI.Airports;

import com.example.FlightSearchAPI.Flights.Flight;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/airports")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService){
        this.airportService = airportService;
    }


    @GetMapping
    public List<Airport> getAirpot(){
            return airportService.getAirpot();
    }

    @PostMapping
    public void registerNewAirport(@RequestBody Airport airport){
        airportService.addNewAirport(airport);
    }

    @DeleteMapping(path = "{airportId}")
    public void deleteAirport(@PathVariable("airportId")Long airportId){
        airportService.deleteAirport(airportId);

    }

    @PutMapping(path = "{airportId}")
    public void updateAirport(
            @PathVariable("airportId") Long airportId,
            @RequestParam(required = false) String city){
            airportService.updateAirport(airportId,city);
    }









}

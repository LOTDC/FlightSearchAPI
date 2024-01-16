package com.example.FlightSearchAPI.Flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flights")
public class FlightController {

    private  final FlightService flightservice;

    @Autowired
    public FlightController(FlightService flightservice) {
        this.flightservice = flightservice;
    }

    @GetMapping
    public List<Flight> getFlights(){
        return flightservice.getFlights();
    }

    @PostMapping
    public void registerNewFlight(@RequestBody Flight flight) throws IllegalAccessException {
        flightservice.addNewFlight(flight);
    }

    @DeleteMapping(path = "{flightId}")
    public void deleteFlight(@PathVariable("flightId") Long flightid) throws IllegalAccessException {
        flightservice.deleteFlight(flightid);
    }

    @PutMapping(path = "{flightId}")
    public void updateFlight(
            @PathVariable("flightId") Long flightId,
            @RequestParam(required = false) String departure,
            @RequestParam(required = false) String email){
            flightservice.updateFlight(flightId,departure,email);
    }


}




package com.example.FlightSearchAPI.Flights;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "api/v1/flights",produces = MediaType.APPLICATION_JSON_VALUE)
//@OpenAPIDefinition(info = @Info(title = "FLight API", version = "v1"))
//public class FlightController {
//
//    private  final FlightService flightservice;
//
//    @Autowired
//    public FlightController(FlightService flightservice) {
//        this.flightservice = flightservice;
//    }
//
//    @GetMapping
//    public List<Flight> getFlights(){
//        return flightservice.getFlights();
//    }
//
//    @PostMapping
//    public void registerNewFlight(@RequestBody Flight flight) throws IllegalAccessException {
//        flightservice.addNewFlight(flight);
//    }
//
//    @DeleteMapping(path = "{flightId}")
//    public void deleteFlight(@PathVariable("flightId") Long flightid) throws IllegalAccessException {
//        flightservice.deleteFlight(flightid);
//    }
//
//    @PutMapping(path = "{flightId}")
//    public void updateFlight(
//            @PathVariable("flightId") Long flightId,
//            @RequestParam(required = false) String departure,
//            @RequestParam(required = false) String email){
//            flightservice.updateFlight(flightId,departure,email);
//    }
//
//
//
//}

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "basicAuth")
@RestController
@RequestMapping(value = "api/v1/flights", produces = MediaType.APPLICATION_JSON_VALUE)
@OpenAPIDefinition(info = @Info(title = "Flight API", version = "v1"))
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> findAllFlights() {
        return flightService.getFlights();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFlight(@RequestBody Flight flight) throws IllegalAccessException {
        flightService.addNewFlight(flight);
    }

    @DeleteMapping("{flightId}")
    public void deleteFlight(@PathVariable("flightId") Long flightId) throws IllegalAccessException {
        flightService.deleteFlight(flightId);
    }

    @PutMapping("{flightId}")
    public void updateFlight(
            @PathVariable("flightId") Long flightId,
            @RequestParam(required = false) String departure,
            @RequestParam(required = false) String email) {
        flightService.updateFlight(flightId, departure, email);
    }
}



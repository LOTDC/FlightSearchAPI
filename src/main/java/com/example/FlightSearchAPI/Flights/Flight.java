package com.example.FlightSearchAPI.Flights;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table
public class Flight {
    @Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName =  "flight_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flight_sequence"
    )

    private Long ID;
    private String email;
    private String departure;
    private String arrival;
    private LocalDateTime departueDT;
    private LocalDateTime arrivalDT;

    private LocalDateTime returntime;
    private double price;

    public Flight(String departure, String email, String arrival, LocalDateTime departueDT, LocalDateTime arrivalDT, double price) {
        this.departure = departure;
        this.arrival = arrival;
        this.departueDT = departueDT;
        this.arrivalDT = arrivalDT;
        this.price = price;
        this.email =email;
    }

    public Flight(Long ID, String departure, String arrival, LocalDateTime departueDT, LocalDateTime arrivalDT, double price) {
        this.ID = ID;
        this.departure = departure;
        this.arrival = arrival;
        this.departueDT = departueDT;
        this.arrivalDT = arrivalDT;
        this.price = price;
    }

    public Flight(String email, String departure, String arrival, LocalDateTime departueDT, LocalDateTime arrivalDT, LocalDateTime returntime, double price) {
        this.email = email;
        this.departure = departure;
        this.arrival = arrival;
        this.departueDT = departueDT;
        this.arrivalDT = arrivalDT;
        this.returntime = returntime;
        this.price = price;
    }

    public Flight() {

    }

    public LocalDateTime getReturntime() {
        return returntime;
    }

    public void setReturntime(LocalDateTime returntime) {
        this.returntime = returntime;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDepartueDT() {
        return departueDT;
    }

    public void setDepartueDT(LocalDateTime departueDT) {
        this.departueDT = departueDT;
    }

    public LocalDateTime getArrivalDT() {
        return arrivalDT;
    }

    public void setArrivalDT(LocalDateTime arrivalDT) {
        this.arrivalDT = arrivalDT;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "ID=" + ID +
                ", email='" + email + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", departueDT=" + departueDT +
                ", arrivalDT=" + arrivalDT +
                ", price=" + price +
                '}';
    }
}

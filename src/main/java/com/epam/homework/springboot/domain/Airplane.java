package com.epam.homework.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String modelNumber;

    @Getter
    @Setter
    private int capacity;

    @JsonIgnore
    @OneToMany(
            mappedBy = "airplane",
            fetch = FetchType.LAZY
    )
    @Getter
    private List<Flight> flights = new ArrayList<>();

    public Airplane(String modelNumber, int capacity) {
        this.modelNumber = modelNumber;
        this.capacity = capacity;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        flight.setAirplane(this);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
        flight.setAirplane(null);
    }
}

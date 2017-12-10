package com.epam.homework.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "passengers")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String fromLoc;

    @Getter
    @Setter
    private String toLoc;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter
    @Setter
    private Timestamp departure;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter
    @Setter
    private Timestamp arrival;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @Getter
    @Setter
    private Airplane airplane;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @Getter
    private Set<Passenger> passengers = new HashSet<>();

    public Flight(String fromLoc, String toLoc, Timestamp departure, Timestamp arrival) {
        this.fromLoc = fromLoc;
        this.toLoc = toLoc;
        this.departure = departure;
        this.arrival = arrival;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.getFlights().add(this);
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.getFlights().remove(this);
    }
}

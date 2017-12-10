package com.epam.homework.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "flights")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Gender gender;

    @OneToOne(
            mappedBy = "passenger",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @Getter
    @Setter
    private PassengerContactInfo contactInfo;

    @JsonIgnore
    @ManyToMany(
            mappedBy = "passengers",
            fetch = FetchType.EAGER
    )
    @Getter
    private Set<Flight> flights = new HashSet<>();

    public Passenger(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public void setContactInfo(PassengerContactInfo passengerContactInfo) {
        this.contactInfo = passengerContactInfo;
        passengerContactInfo.setPassenger(this);
    }
}

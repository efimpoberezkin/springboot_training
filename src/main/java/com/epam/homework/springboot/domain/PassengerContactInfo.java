package com.epam.homework.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PassengerContactInfo {

    @Id
    private Long id;

    private String email;

    private String phone;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Passenger passenger;

    public PassengerContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
}

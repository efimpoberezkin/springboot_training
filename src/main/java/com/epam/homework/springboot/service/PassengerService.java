package com.epam.homework.springboot.service;

import com.epam.homework.springboot.domain.Gender;
import com.epam.homework.springboot.domain.Passenger;
import com.epam.homework.springboot.domain.PassengerContactInfo;

import java.util.List;

public interface PassengerService extends Service<Passenger> {

    @Override
    Passenger save(Passenger passenger);

    @Override
    List<Passenger> findAll();

    @Override
    Passenger findBy(long id);

    @Override
    Passenger update(Passenger passenger);

    @Override
    void delete(long id) throws UnsupportedOperationException;

    Passenger addContactInfoToPassenger(long passengerId, PassengerContactInfo info);

    List<Passenger> findByGender(Gender gender);
}

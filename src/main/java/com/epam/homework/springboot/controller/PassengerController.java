package com.epam.homework.springboot.controller;

import com.epam.homework.springboot.domain.Gender;
import com.epam.homework.springboot.domain.Passenger;
import com.epam.homework.springboot.domain.PassengerContactInfo;

import java.util.List;

public interface PassengerController extends Controller<Passenger> {

    @Override
    List<Passenger> getAll();

    @Override
    Passenger getById(long id);

    @Override
    Passenger add(Passenger passenger);

    @Override
    Passenger update(Passenger passenger);

    @Override
    void delete(long id) throws UnsupportedOperationException;

    Passenger addContactInfoToPassenger(long passengerId, PassengerContactInfo info);

    List<Passenger> findByGender(Gender gender);
}

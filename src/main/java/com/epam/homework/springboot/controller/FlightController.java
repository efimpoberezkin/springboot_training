package com.epam.homework.springboot.controller;

import com.epam.homework.springboot.domain.Flight;

import java.util.List;

public interface FlightController extends Controller<Flight> {

    @Override
    List<Flight> getAll();

    @Override
    Flight getById(long id);

    @Override
    Flight add(Flight flight);

    @Override
    Flight update(Flight flight);

    @Override
    void delete(long id);

    Flight addPassengerToFlight(long flightId, long passengerId);

    void removePassengerFromFlight(long flightId, long passengerId);

    List<Flight> findByFromLocAndToLoc(String fromLoc, String toLoc);
}

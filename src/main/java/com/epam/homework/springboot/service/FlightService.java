package com.epam.homework.springboot.service;

import com.epam.homework.springboot.domain.Flight;

import java.util.List;

public interface FlightService extends Service<Flight> {

    @Override
    Flight save(Flight flight);

    @Override
    List<Flight> findAll();

    @Override
    Flight findBy(long id);

    @Override
    Flight update(Flight flight);

    @Override
    void delete(long id);

    Flight addPassengerToFlight(long flightId, long passengerId);

    void removePassengerFromFlight(long flightId, long passengerId);

    List<Flight> findByFromLocAndToLoc(String fromLoc, String toLoc);
}

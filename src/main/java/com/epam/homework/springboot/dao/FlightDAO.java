package com.epam.homework.springboot.dao;

import com.epam.homework.springboot.domain.Flight;

import java.util.List;

public interface FlightDAO extends DAO<Flight> {

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
}

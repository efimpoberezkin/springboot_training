package com.epam.homework.springboot.dao;

import com.epam.homework.springboot.domain.Passenger;

import java.util.List;

public interface PassengerDAO extends DAO<Passenger> {

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
}

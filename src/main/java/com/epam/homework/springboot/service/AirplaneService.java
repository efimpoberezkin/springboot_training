package com.epam.homework.springboot.service;

import com.epam.homework.springboot.domain.Airplane;

import java.util.List;

public interface AirplaneService extends Service<Airplane> {

    @Override
    Airplane save(Airplane airplane);

    @Override
    List<Airplane> findAll();

    @Override
    Airplane findBy(long id);

    @Override
    Airplane update(Airplane airplane);

    @Override
    void delete(long id);
}

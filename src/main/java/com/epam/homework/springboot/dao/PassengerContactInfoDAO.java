package com.epam.homework.springboot.dao;

import com.epam.homework.springboot.domain.PassengerContactInfo;

import java.util.List;

public interface PassengerContactInfoDAO extends DAO<PassengerContactInfo> {

    @Override
    PassengerContactInfo save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException;

    @Override
    List<PassengerContactInfo> findAll() throws UnsupportedOperationException;

    @Override
    PassengerContactInfo findBy(long id);

    @Override
    PassengerContactInfo update(PassengerContactInfo passengerContactInfo);

    @Override
    void delete(long id);
}

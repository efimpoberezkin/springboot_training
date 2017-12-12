package com.epam.homework.springboot.service.impl;

import com.epam.homework.springboot.repository.PassengerRepository;
import com.epam.homework.springboot.domain.Gender;
import com.epam.homework.springboot.domain.Passenger;
import com.epam.homework.springboot.domain.PassengerContactInfo;
import com.epam.homework.springboot.service.PassengerService;
import com.epam.homework.springboot.service.ServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Resource
    private PassengerRepository passengerRepository;

    @Override
    @Transactional
    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    @Transactional
    public List<Passenger> findAll() {
        return (List<Passenger>) passengerRepository.findAll();
    }

    @Override
    @Transactional
    public Passenger findBy(long id) throws ServiceException {
        try {
            return passengerRepository.findOne(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger by id " + id, e);
        }
    }

    @Override
    @Transactional
    public Passenger update(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    @Transactional
    public void delete(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }

    @Override
    @Transactional
    public Passenger addContactInfoToPassenger(long passengerId, PassengerContactInfo info) throws ServiceException {
        try {
            Passenger passenger = passengerRepository.findOne(passengerId);
            passenger.setContactInfo(info);
            return passengerRepository.save(passenger);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to add contact info to passenger: could not find passenger by id " + passengerId, e);
        }
    }

    @Override
    public List<Passenger> findByGender(Gender gender) {
        return passengerRepository.findByGender(gender);
    }
}

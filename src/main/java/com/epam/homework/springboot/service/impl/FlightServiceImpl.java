package com.epam.homework.springboot.service.impl;

import com.epam.homework.springboot.domain.Flight;
import com.epam.homework.springboot.domain.Passenger;
import com.epam.homework.springboot.repository.FlightRepository;
import com.epam.homework.springboot.repository.PassengerRepository;
import com.epam.homework.springboot.service.FlightService;
import com.epam.homework.springboot.service.ServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Resource
    private FlightRepository flightRepository;
    @Resource
    private PassengerRepository passengerRepository;

    @Override
    @Transactional
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    @Transactional
    public List<Flight> findAll() {
        return (List<Flight>) flightRepository.findAll();
    }

    @Override
    @Transactional
    public Flight findBy(long id) throws ServiceException {
        try {
            return flightRepository.findOne(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find flight by id " + id, e);
        }
    }

    @Override
    @Transactional
    public Flight update(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    @Transactional
    public void delete(long id) throws ServiceException {
        try {
            flightRepository.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find flight by id " + id, e);
        }
    }

    @Override
    @Transactional
    public Flight addPassengerToFlight(long flightId, long passengerId) throws ServiceException {
        try {
            Flight flight = flightRepository.findOne(flightId);
            try {
                Passenger passenger = passengerRepository.findOne(passengerId);
                flight.addPassenger(passenger);
                return flightRepository.save(flight);
            } catch (NoResultException e) {
                throw new ServiceException("Failed to add passenger to flight: could not find passenger by id " + passengerId, e);
            }
        } catch (NoResultException e) {
            throw new ServiceException("Failed to add passenger to flight: could not find flight by id " + flightId, e);
        }
    }

    @Override
    @Transactional
    public void removePassengerFromFlight(long flightId, long passengerId) throws ServiceException {
        try {
            Flight flight = flightRepository.findOne(flightId);
            try {
                Passenger passenger = passengerRepository.findOne(passengerId);
                flight.removePassenger(passenger);
                flightRepository.save(flight);
            } catch (NoResultException e) {
                throw new ServiceException("Failed to remove passenger from flight: could not find passenger by id " + passengerId, e);
            }
        } catch (NoResultException e) {
            throw new ServiceException("Failed to remove passenger from flight: could not find flight by id " + flightId, e);
        }
    }
}

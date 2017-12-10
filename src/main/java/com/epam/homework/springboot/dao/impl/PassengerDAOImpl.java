package com.epam.homework.springboot.dao.impl;

import com.epam.homework.springboot.dao.PassengerDAO;
import com.epam.homework.springboot.domain.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

    private static final String FIND_ALL_PASSENGERS = "SELECT p FROM Passenger p";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Passenger save(Passenger passenger) {
        entityManager.persist(passenger);
        return passenger;
    }

    @Override
    public List<Passenger> findAll() {
        return entityManager.createQuery(FIND_ALL_PASSENGERS, Passenger.class).getResultList();
    }

    @Override
    public Passenger findBy(long id) {
        return entityManager.find(Passenger.class, id);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return entityManager.merge(passenger);
    }

    @Override
    public void delete(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }
}

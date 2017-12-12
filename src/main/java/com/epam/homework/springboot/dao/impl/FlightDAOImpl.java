package com.epam.homework.springboot.dao.impl;

import com.epam.homework.springboot.dao.FlightDAO;
import com.epam.homework.springboot.domain.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FlightDAOImpl implements FlightDAO {

    private static final String FIND_ALL_FLIGHTS = "SELECT f FROM Flight f";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Flight save(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    @Override
    public List<Flight> findAll() {
        return entityManager.createQuery(FIND_ALL_FLIGHTS, Flight.class).getResultList();
    }

    @Override
    public Flight findBy(long id) {
        return entityManager.find(Flight.class, id);
    }

    @Override
    public Flight update(Flight flight) {
        return entityManager.merge(flight);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findBy(id));
    }
}

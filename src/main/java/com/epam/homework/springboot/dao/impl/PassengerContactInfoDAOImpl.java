package com.epam.homework.springboot.dao.impl;

import com.epam.homework.springboot.dao.PassengerContactInfoDAO;
import com.epam.homework.springboot.domain.PassengerContactInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PassengerContactInfoDAOImpl implements PassengerContactInfoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PassengerContactInfo save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @Override
    public List<PassengerContactInfo> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public PassengerContactInfo findBy(long id) {
        return entityManager.find(PassengerContactInfo.class, id);
    }

    @Override
    public PassengerContactInfo update(PassengerContactInfo passengerContactInfo) {
        return entityManager.merge(passengerContactInfo);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findBy(id));
    }
}

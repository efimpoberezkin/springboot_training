package com.epam.homework.springboot.dao.impl;

import com.epam.homework.springboot.dao.AirplaneDAO;
import com.epam.homework.springboot.domain.Airplane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AirplaneDAOImpl implements AirplaneDAO {

    private static final String FIND_ALL_AIRPLANES = "SELECT a FROM Airplane a";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Airplane save(Airplane airplane) {
        entityManager.persist(airplane);
        return airplane;
    }

    @Override
    public List<Airplane> findAll() {
        return entityManager.createQuery(FIND_ALL_AIRPLANES, Airplane.class).getResultList();
    }

    @Override
    public Airplane findBy(long id) {
        return entityManager.find(Airplane.class, id);
    }

    @Override
    public Airplane update(Airplane airplane) {
        return entityManager.merge(airplane);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findBy(id));
    }
}

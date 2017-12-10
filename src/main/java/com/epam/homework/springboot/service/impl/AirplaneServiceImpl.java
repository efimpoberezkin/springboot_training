package com.epam.homework.springboot.service.impl;

import com.epam.homework.springboot.dao.DAO;
import com.epam.homework.springboot.domain.Airplane;
import com.epam.homework.springboot.service.AirplaneService;
import com.epam.homework.springboot.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private DAO<Airplane> airplaneDAO;

    @Override
    @Transactional
    public Airplane save(Airplane airplane) {
        return airplaneDAO.save(airplane);
    }

    @Override
    @Transactional
    public List<Airplane> findAll() {
        return airplaneDAO.findAll();
    }

    @Override
    @Transactional
    public Airplane findBy(long id) throws ServiceException {
        try {
            return airplaneDAO.findBy(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find airplane by id " + id, e);
        }
    }

    @Override
    @Transactional
    public Airplane update(Airplane airplane) {
        return airplaneDAO.update(airplane);
    }

    @Override
    @Transactional
    public void delete(long id) throws ServiceException {
        try {
            airplaneDAO.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find airplane by id " + id, e);
        }
    }
}

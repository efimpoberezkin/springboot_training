package com.epam.homework.springboot.service.impl;

import com.epam.homework.springboot.domain.Airplane;
import com.epam.homework.springboot.repository.AirplaneRepository;
import com.epam.homework.springboot.service.AirplaneService;
import com.epam.homework.springboot.service.ServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Resource
    private AirplaneRepository airplaneRepository;

    @Override
    @Transactional
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    @Transactional
    public List<Airplane> findAll() {
        return (List<Airplane>) airplaneRepository.findAll();
    }

    @Override
    @Transactional
    public Airplane findBy(long id) throws ServiceException {
        try {
            return airplaneRepository.findOne(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find airplane by id " + id, e);
        }
    }

    @Override
    @Transactional
    public Airplane update(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    @Transactional
    public void delete(long id) throws ServiceException {
        try {
            airplaneRepository.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find airplane by id " + id, e);
        }
    }
}

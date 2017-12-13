package com.epam.homework.springboot.service.impl;

import com.epam.homework.springboot.domain.PassengerContactInfo;
import com.epam.homework.springboot.repository.PassengerContactInfoRepository;
import com.epam.homework.springboot.service.PassengerContactInfoService;
import com.epam.homework.springboot.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PassengerContactInfoServiceImpl implements PassengerContactInfoService {

    @Autowired
    private PassengerContactInfoRepository passengerContactInfoRepository;

    @Override
    @Transactional
    public PassengerContactInfo save(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @Override
    @Transactional
    public List<PassengerContactInfo> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    @Transactional
    public PassengerContactInfo findBy(long id) throws ServiceException {
        try {
            return passengerContactInfoRepository.findOne(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger contact info by id " + id, e);
        }
    }

    @Override
    @Transactional
    public PassengerContactInfo update(PassengerContactInfo passengerContactInfo) {
        return passengerContactInfoRepository.save(passengerContactInfo);
    }

    @Override
    @Transactional
    public void delete(long id) throws ServiceException {
        try {
            passengerContactInfoRepository.delete(id);
        } catch (NoResultException e) {
            throw new ServiceException("Failed to find passenger contact info by id " + id, e);
        }
    }
}

package com.epam.homework.springboot.controller.impl;

import com.epam.homework.springboot.controller.ControllerException;
import com.epam.homework.springboot.controller.PassengerContactInfoController;
import com.epam.homework.springboot.domain.PassengerContactInfo;
import com.epam.homework.springboot.service.Service;
import com.epam.homework.springboot.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengerinfo")
public class PassengerContactInfoControllerImpl implements PassengerContactInfoController {

    @Autowired
    private Service<PassengerContactInfo> passengerContactInfoService;

    @Override
    public List<PassengerContactInfo> getAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @GetMapping("/{id}")
    @Override
    public PassengerContactInfo getById(@PathVariable long id) throws ControllerException {
        try {
            return passengerContactInfoService.findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get passenger info", e);
        }
    }

    @Override
    public PassengerContactInfo add(PassengerContactInfo passengerContactInfo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger info has to be saved via passenger");
    }

    @PutMapping
    @Override
    public PassengerContactInfo update(@RequestBody PassengerContactInfo passengerContactInfo) {
        return passengerContactInfoService.update(passengerContactInfo);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable long id) throws ControllerException {
        try {
            passengerContactInfoService.delete(id);
        } catch (ServiceException e) { //ignore
        }
    }
}

package com.epam.homework.springboot.controller.impl;

import com.epam.homework.springboot.controller.ControllerException;
import com.epam.homework.springboot.controller.PassengerController;
import com.epam.homework.springboot.domain.Gender;
import com.epam.homework.springboot.domain.Passenger;
import com.epam.homework.springboot.domain.PassengerContactInfo;
import com.epam.homework.springboot.service.PassengerService;
import com.epam.homework.springboot.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${passengers.uri}")
public class PassengerControllerImpl implements PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    @Override
    public List<Passenger> getAll() {
        return passengerService.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public Passenger getById(@PathVariable long id) throws ControllerException {
        try {
            return passengerService.findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get passenger", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public Passenger add(@RequestBody Passenger passenger) {
        return passengerService.save(passenger);
    }

    @PutMapping
    @Override
    public Passenger update(@RequestBody Passenger passenger) {
        return passengerService.update(passenger);
    }

    @Override
    public void delete(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation not supported: passenger has to be deleted via flight");
    }

    @PutMapping("/{passengerid}/passengerinfo")
    @Override
    public Passenger addContactInfoToPassenger(
            @PathVariable("passengerid") long passengerId,
            @RequestBody PassengerContactInfo passengerContactInfo) throws ControllerException {
        try {
            return passengerService.addContactInfoToPassenger(passengerId, passengerContactInfo);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to add contact info to passenger", e);
        }
    }

    @GetMapping("/gender/{gender}")
    @Override
    public List<Passenger> findByGender(@PathVariable Gender gender) {
        return passengerService.findByGender(gender);
    }
}

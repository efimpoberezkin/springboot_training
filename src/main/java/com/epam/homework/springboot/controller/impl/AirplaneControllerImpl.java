package com.epam.homework.springboot.controller.impl;

import com.epam.homework.springboot.controller.AirplaneController;
import com.epam.homework.springboot.controller.ControllerException;
import com.epam.homework.springboot.domain.Airplane;
import com.epam.homework.springboot.service.Service;
import com.epam.homework.springboot.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${airplanes.uri}")
public class AirplaneControllerImpl implements AirplaneController {

    @Autowired
    private Service<Airplane> airplaneService;

    @GetMapping
    @Override
    public List<Airplane> getAll() {
        return airplaneService.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public Airplane getById(@PathVariable long id) throws ControllerException {
        try {
            return airplaneService.findBy(id);
        } catch (ServiceException e) {
            throw new ControllerException("Failed to get airplane", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public Airplane add(@RequestBody Airplane airplane) {
        return airplaneService.save(airplane);
    }

    @PutMapping
    @Override
    public Airplane update(@RequestBody Airplane airplane) {
        return airplaneService.update(airplane);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable long id) throws ControllerException {
        try {
            airplaneService.delete(id);
        } catch (ServiceException e) { //ignore
        }
    }
}

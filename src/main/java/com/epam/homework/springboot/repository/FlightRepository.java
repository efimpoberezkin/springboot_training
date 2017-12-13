package com.epam.homework.springboot.repository;

import com.epam.homework.springboot.domain.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {

    List<Flight> findByFromLocAndToLoc(String fromLoc, String toLoc);
}

package com.epam.homework.springboot.repository;

import com.epam.homework.springboot.domain.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
}

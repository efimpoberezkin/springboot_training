package com.epam.homework.springboot.repository;

import com.epam.homework.springboot.domain.Gender;
import com.epam.homework.springboot.domain.Passenger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {

    List<Passenger> findByGender(Gender gender);
}

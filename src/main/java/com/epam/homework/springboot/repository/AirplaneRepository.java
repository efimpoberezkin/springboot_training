package com.epam.homework.springboot.repository;

import com.epam.homework.springboot.domain.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
}

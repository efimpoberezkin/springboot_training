package com.epam.homework.springboot.repository;

import com.epam.homework.springboot.domain.PassengerContactInfo;
import org.springframework.data.repository.CrudRepository;

public interface PassengerContactInfoRepository extends CrudRepository<PassengerContactInfo, Long> {
}

package com.epam.homework.springboot.service;

import java.util.List;

public interface Service<T> {

    T save(T object);

    List<T> findAll();

    T findBy(long id);

    T update(T object);

    void delete(long id);
}

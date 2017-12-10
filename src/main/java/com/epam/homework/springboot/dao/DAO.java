package com.epam.homework.springboot.dao;

import java.util.List;

public interface DAO<T> {

    T save(T object);

    List<T> findAll();

    T findBy(long id);

    T update(T object);

    void delete(long id);
}

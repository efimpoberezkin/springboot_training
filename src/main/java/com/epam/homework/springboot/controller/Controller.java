package com.epam.homework.springboot.controller;

import java.util.List;

public interface Controller<T> {

    List<T> getAll();

    T getById(long id);

    T add(T object);

    T update(T object);

    void delete(long id);
}

package com.blyskitka.DAO.Interfaces;

import java.util.List;

public interface Dao <T> {
    void insert(T obj);
    T getById(int id);
    void update(T obj);
    void delete(T obj);
    List<T> getAll();
}

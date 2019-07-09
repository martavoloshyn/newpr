package com.blyskitka.DAO.Interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao <T> {
    void insert(T obj) throws SQLException;
    T getById(int id) throws SQLException;
    void update(T obj) throws SQLException;
    void delete(T obj) throws SQLException;
    List<T> getAll() throws SQLException;
}

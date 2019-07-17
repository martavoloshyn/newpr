package com.blyskitka.DAO.Interfaces;

import com.blyskitka.Entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    List<Category> getAll() throws SQLException;
}

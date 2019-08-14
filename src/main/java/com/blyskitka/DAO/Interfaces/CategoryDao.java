package com.blyskitka.DAO.Interfaces;

import com.blyskitka.Entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao extends Dao<Category>{

    List<Category> getAll() throws SQLException;
}

package com.blyskitka.Service.Interfaces;

import com.blyskitka.Entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService extends Service<Category>{

    List<Category> getAll() throws SQLException;
}

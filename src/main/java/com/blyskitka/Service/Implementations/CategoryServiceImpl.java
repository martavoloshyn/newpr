package com.blyskitka.Service.Implementations;

import com.blyskitka.DAO.Implementations.CategoryDaoImpl;
import com.blyskitka.DAO.Interfaces.CategoryDao;
import com.blyskitka.Entity.Category;
import com.blyskitka.Service.Interfaces.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl() {
        this.categoryDao = new CategoryDaoImpl();
    }

    @Override
    public List<Category> getAll() throws SQLException {

         return categoryDao.getAll();
    }
}

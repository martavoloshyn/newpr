package com.blyskitka.Service.Implementations;

import com.blyskitka.DAO.Implementations.CategoryDaoImpl;
import com.blyskitka.DAO.Interfaces.CategoryDao;
import com.blyskitka.Entity.Category;
import com.blyskitka.Service.Interfaces.CategoryService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public void insert(Category obj) throws SQLException {
        categoryDao.insert(obj);
    }

    @Override
    public Category getById(int id) throws SQLException {
        return categoryDao.getById(id);
    }
    @Override
    public void update(Category obj) throws SQLException {
        categoryDao.update(obj);
    }
    @Override
    public void delete(Category obj) throws SQLException {
        categoryDao.delete(obj);
    }
}

package com.blyskitka.DAO.Implementations;

import com.blyskitka.DAO.Interfaces.CategoryDao;
import com.blyskitka.Entity.Category;
import com.blyskitka.JDBC.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {


    private Connection connection;

    public CategoryDaoImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public void insert(Category obj) throws SQLException {
        String query = "INSERT INTO categories (id, category) VALUES(?,?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.setString(2,obj.getCategory());
        statement.execute();
        statement.close();
    }

    @Override
    public Category getById(int id) throws SQLException {
        String query = "SELECT * FROM categories WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        Category category = new Category();

        ResultSet set = statement.executeQuery();
        if (set.next()) {
            category.setId(set.getInt("id"));
            category.setCategory(set.getString("category"));
        }
        set.close();
        statement.close();
        return category;
    }

    @Override
    public void update(Category obj) throws SQLException {
        String query ="UPDATE categories SET category=? WHERE id=?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,obj.getCategory());
        statement.setInt(2,obj.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public void delete(Category obj) throws SQLException {
        String query = "DELETE FROM categories WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public List<Category> getAll() throws SQLException {

        String query = "SELECT * FROM categories";

        PreparedStatement statement = connection.prepareStatement(query);
        List<Category> categories = new ArrayList<>();
        ResultSet set = statement.executeQuery();

        while(set.next()){
            Category category = new Category();
            category.setId(set.getInt("id"));
            category.setCategory(set.getString("category"));
            categories.add(category);
        }

        set.close();
        statement.close();

        return categories;
    }
}

package com.blyskitka.DAO.Implementations;

import com.blyskitka.DAO.Interfaces.CategoryDao;
import com.blyskitka.Entity.Category;
import com.blyskitka.JDBC.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {


    private Connection connection;

    public CategoryDaoImpl() {
        connection = DBConnection.getConnection();
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

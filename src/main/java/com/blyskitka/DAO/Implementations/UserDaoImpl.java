package com.blyskitka.DAO.Implementations;

import Entity.User;
import com.blyskitka.DAO.Interfaces.UserDao;
import com.blyskitka.JDBC.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection connection ;


    public UserDaoImpl(){
        connection = DBConnection.getConnection();
    }

    public User getUserByLogin(String login) throws SQLException {
        String query="SELECT * FROM users WHERE login=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,login);
        ResultSet set = statement.executeQuery();
        User user = new User();
        if (set.next()) {
            user.setId(set.getInt("id"));
            user.setSurname(set.getString("surname"));
            user.setName(set.getString("name"));
            user.setPhoneNumber(set.getString("phoneNumber"));
            user.setEmail(set.getString("email"));
            user.setCity(set.getString("city"));
            user.setStreet(set.getString("street"));
            user.setHouse(set.getInt("house"));
            user.setApartment(set.getInt("apartment"));
            user.setLogin(set.getString("login"));
            user.setPassword(set.getString("password"));
        }
        set.close();
        statement.close();
        return user;
    }

    public void insert(User obj) throws SQLException {
        String query = "INSERT INTO users (id,surname, name,phoneNumber,email,city, street,house, " +
                "apartment, login, password) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.setString(2,obj.getSurname());
        statement.setString(3,obj.getName());
        statement.setString(4,obj.getPhoneNumber());
        statement.setString(5,obj.getEmail());
        statement.setString(6,obj.getCity());
        statement.setString(7,obj.getStreet());
        statement.setInt(8,obj.getHouse());
        statement.setInt(9,obj.getApartment());
        statement.setString(10,obj.getLogin());
        statement.setString(11,obj.getPassword());
        statement.execute();
        statement.close();
    }

    public User getById(int id) throws SQLException {
        String query="SELECT * FROM users WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        ResultSet set = statement.executeQuery();
        User user = new User();
        if (set.next()) {
            user.setId(set.getInt("id"));
            user.setSurname(set.getString("surname"));
            user.setName(set.getString("name"));
            user.setPhoneNumber(set.getString("phoneNumber"));
            user.setEmail(set.getString("email"));
            user.setCity(set.getString("city"));
            user.setStreet(set.getString("street"));
            user.setHouse(set.getInt("house"));
            user.setApartment(set.getInt("apartment"));
            user.setLogin(set.getString("login"));
            user.setPassword(set.getString("password"));
        }
        set.close();
        statement.close();
        return user;
    }

    public void update(User obj) throws SQLException {

        String query = "UPDATE users SET surname=?, name=?,phoneNumber=?,email=?,city=?, street=?, " +
                "house=?, apartment=?, login=?, password=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,obj.getSurname());
        statement.setString(2,obj.getName());
        statement.setString(3,obj.getPhoneNumber());
        statement.setString(4,obj.getEmail());
        statement.setString(5,obj.getCity());
        statement.setString(6,obj.getStreet());
        statement.setInt(7,obj.getHouse());
        statement.setInt(8,obj.getApartment());
        statement.setString(9,obj.getLogin());
        statement.setString(10,obj.getPassword());
        statement.setInt(11,obj.getId());

        statement.execute();
        statement.close();

    }

    public void delete(User obj) throws SQLException {
        String query = "DELETE FROM users WHERE id=?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.execute();
        statement.close();
    }

    public List<User> getAll() throws SQLException {
        String query = "SELECT * FROM users;";
        LinkedList<User> users = new LinkedList<User>();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            User user = new User();
            user.setId(set.getInt("id"));
            user.setSurname(set.getString("surname"));
            user.setName(set.getString("name"));
            user.setPhoneNumber(set.getString("phoneNumber"));
            user.setEmail(set.getString("email"));
            user.setCity(set.getString("city"));
            user.setStreet(set.getString("street"));
            user.setHouse(set.getInt("house"));
            user.setApartment(set.getInt("apartment"));
            user.setLogin(set.getString("login"));
            user.setPassword(set.getString("password"));
        }
        set.close();
        statement.close();

        return users;
    }
}

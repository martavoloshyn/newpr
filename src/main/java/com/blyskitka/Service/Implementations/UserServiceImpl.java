package com.blyskitka.Service.Implementations;

import Entity.User;
import com.blyskitka.DAO.Implementations.UserDaoImpl;
import com.blyskitka.DAO.Interfaces.UserDao;
import com.blyskitka.Service.Interfaces.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User getUserByLogin(String login) throws SQLException {
        return userDao.getUserByLogin(login);
    }

    @Override
    public void insert(User obj) throws SQLException {
        userDao.insert(obj);
    }

    @Override
    public User getById(int id) throws SQLException {
        return userDao.getById(id);
    }

    @Override
    public void update(User obj) throws SQLException {
        userDao.update(obj);
    }

    @Override
    public void delete(User obj) throws SQLException {
        userDao.delete(obj);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return userDao.getAll();
    }
}

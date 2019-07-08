package com.blyskitka.DAO.Interfaces;
import Entity.User;

public interface UserDao extends Dao<User>{
    User getUserByLogin(String login);

}

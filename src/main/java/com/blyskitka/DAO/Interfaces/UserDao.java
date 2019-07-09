package com.blyskitka.DAO.Interfaces;
import Entity.User;

import java.sql.SQLException;

public interface UserDao extends Dao<User>{
    User getUserByLogin(String login) throws SQLException;

}

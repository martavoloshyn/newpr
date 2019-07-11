package com.blyskitka.Service.Interfaces;

import Entity.User;

import java.sql.SQLException;

public interface UserService extends Service<User> {
    User getUserByLogin(String login) throws SQLException;

}

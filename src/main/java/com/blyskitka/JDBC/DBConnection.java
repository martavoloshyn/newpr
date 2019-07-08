package com.blyskitka.JDBC;

import java.sql.*;

public class DBConnection {

    private static Connection connection=null;

    public static Connection getConnection(){
        if(connection==null)
            return initConnection();
        else
            return connection;
    }

    private static Connection initConnection(){
        String url="jdbc:mysql://localhost:3306/blyskitka";
        String username="root";
        String password="rota2000";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection (url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

package com.blyskitka.DAO.Implementations;

import com.blyskitka.DAO.Interfaces.OrderDao;
import com.blyskitka.Entity.Order;
import com.blyskitka.JDBC.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Double;

public class OrderDaoImpl implements OrderDao {

    private Connection connection;

    public OrderDaoImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public List<Order> getByUser(int idUser) throws SQLException {
        String query ="SELECT * FROM orders WHERE idUser=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idUser);
        ResultSet set = statement.executeQuery();
        List<Order> orders = new ArrayList<Order>();
        while(set.next()){
            Order order = new Order();
            order.setId(set.getInt("id"));
            order.setIdUser(set.getInt("idUser"));
            order.setDate(set.getDate("orderDate").toLocalDate());
            order.setDelivered(set.getBoolean("isDelivered"));
            order.setTotalPrice(set.getDouble("totalPrice"));
            orders.add(order);
        }
        set.close();
        statement.close();
        return orders;
    }

    @Override
    public List<Order> getUndeliveredUserOrders(int idUser) throws SQLException {
        String query ="SELECT * FROM orders WHERE isDelivered=? AND idUser=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setBoolean(1,false);
        statement.setInt(2,idUser);
        ResultSet set = statement.executeQuery();
        List<Order> orders = new ArrayList<Order>();
        while(set.next()){
            Order order = new Order();
            order.setId(set.getInt("id"));
            order.setIdUser(set.getInt("idUser"));
            order.setDate(set.getDate("orderDate").toLocalDate());
            order.setDelivered(set.getBoolean("isDelivered"));
            order.setTotalPrice(set.getDouble("totalPrice"));
            orders.add(order);
        }
        set.close();
        statement.close();
        return orders;
    }

    @Override
    public List<Order> getDeliveredUserOrders(int idUser) throws SQLException {
        String query ="SELECT * FROM orders WHERE isDelivered=? AND idUser=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setBoolean(1,true);
        statement.setInt(2,idUser);
        ResultSet set = statement.executeQuery();
        List<Order> orders = new ArrayList<Order>();
        while(set.next()){
            Order order = new Order();
            order.setId(set.getInt("id"));
            order.setIdUser(set.getInt("idUser"));
            order.setDate(set.getDate("orderDate").toLocalDate());
            order.setDelivered(set.getBoolean("isDelivered"));
            order.setTotalPrice(set.getDouble("totalPrice"));
            orders.add(order);
        }
        set.close();
        statement.close();
        return orders;
    }

    @Override
    public Double countTotalOrderPrice(Order order) throws SQLException {
        Double totalOrderPrice= Double.valueOf(0);
        String query1 = "SELECT * FROM articleOrder WHERE  idOrder=?";
        String query2 = "SELECT * FROM articles WHERE id=?";
        PreparedStatement statement1 = connection.prepareStatement(query1);
        statement1.setInt(1,order.getId());
        PreparedStatement statement2 = connection.prepareStatement(query2);
        ResultSet set1 = statement1.executeQuery();
        while(set1.next()){
            int amount = set1.getInt("amount");
            int idArticle = set1.getInt("idArticle");
            statement2.setInt(1,idArticle);
            ResultSet set2 = statement2.executeQuery();
            if(set2.next()){
                totalOrderPrice+=set2.getDouble("price")*amount;
            }
            set2.close();
        }
        set1.close();
        statement1.close();
        statement2.close();
        return totalOrderPrice;
    }

    @Override
    public void insert(Order obj) throws SQLException {
        String query = "INSERT INTO orders (id, idUser, orderDate, isDelivered, totalPrice) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.setInt(2,obj.getIdUser());
        statement.setDate(3, Date.valueOf(obj.getDate()));
        statement.setBoolean(4,obj.getDelivered());
        statement.setDouble(5,obj.getTotalPrice());
        statement.execute();
        statement.close();
    }

    @Override
    public Order getById(int id) throws SQLException {
        String query ="SELECT * FROM orders WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        ResultSet set = statement.executeQuery();
        Order order = new Order();
        if(set.next()){
            order.setId(set.getInt("id"));
            order.setIdUser(set.getInt("idUser"));
            order.setDate(set.getDate("orderDate").toLocalDate());
            order.setDelivered(set.getBoolean("isDelivered"));
            order.setTotalPrice(set.getDouble("totalPrice"));
        }
        set.close();
        statement.close();
        return order;
    }

    @Override
    public void update(Order obj) throws SQLException {
        String query = "UPDATE orders SET idUser=?, orderDate=?, isDelivered=?, totalPrice=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getIdUser());
        statement.setDate(2, Date.valueOf(obj.getDate()));
        statement.setBoolean(3,obj.getDelivered());
        statement.setDouble(4,obj.getTotalPrice());
        statement.setInt(5,obj.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public void delete(Order obj) throws SQLException {
        String query = "DELETE FROM orders WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public List<Order> getAll() throws SQLException {
        String query ="SELECT * FROM orders ";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet set = statement.executeQuery();
        List<Order> orders = new ArrayList<Order>();
        while(set.next()){
            Order order = new Order();
            order.setId(set.getInt("id"));
            order.setIdUser(set.getInt("idUser"));
            order.setDate(set.getDate("orderDate").toLocalDate());
            order.setDelivered(set.getBoolean("isDelivered"));
            order.setTotalPrice(set.getDouble("totalPrice"));
            orders.add(order);
        }
        set.close();
        statement.close();
        return orders;
    }
}

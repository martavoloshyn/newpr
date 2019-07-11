package com.blyskitka.Service.Implementations;

import com.blyskitka.DAO.Implementations.OrderDaoImpl;
import com.blyskitka.DAO.Interfaces.OrderDao;
import com.blyskitka.Entity.Order;
import com.blyskitka.Service.Interfaces.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        orderDao = new OrderDaoImpl();
    }

    @Override
    public List<Order> getByUser(int idUser) throws SQLException {
        return orderDao.getByUser(idUser);
    }

    @Override
    public List<Order> getUndeliveredUserOrders(int idUser) throws SQLException {
        return orderDao.getUndeliveredUserOrders(idUser);
    }

    @Override
    public List<Order> getDeliveredUserOrders(int idUser) throws SQLException {
        return orderDao.getDeliveredUserOrders(idUser);
    }

    @Override
    public Double countTotalOrderPrice(Order order) throws SQLException {
        return orderDao.countTotalOrderPrice(order);
    }

    @Override
    public void insert(Order obj) throws SQLException {
        orderDao.insert(obj);
    }

    @Override
    public Order getById(int id) throws SQLException {
        return orderDao.getById(id);
    }

    @Override
    public void update(Order obj) throws SQLException {
        orderDao.update(obj);
    }

    @Override
    public void delete(Order obj) throws SQLException {
        orderDao.delete(obj);
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return orderDao.getAll();
    }
}

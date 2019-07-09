package com.blyskitka.DAO.Interfaces;
import com.blyskitka.Entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getByUser(int idUser) throws SQLException;
    List<Order> getUndeliveredUserOrders(int idUser) throws SQLException;
    List<Order> getDeliveredUserOrders(int idUser) throws SQLException;
    Double countTotalOrderPrice(Order order) throws SQLException;
}

package com.blyskitka.DAO.Interfaces;
import Entity.Order;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getByUser(int idUser);
    List<Order> getUndeliveredUserOrders();
    List<Order> getDeliveredUserOrders();
    Integer countTotalPrice(Order order);
}

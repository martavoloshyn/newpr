package com.blyskitka.Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    Integer id;
    Integer idUser;
    LocalDate date;
    Boolean isDelivered;
    Double totalPrice;

    public Order() {
    }

    public Order(Integer id, Integer idUser, LocalDate date, Boolean isDelivered, Double totalPrice) {
        this.id = id;
        this.idUser = idUser;
        this.date = date;
        this.isDelivered = isDelivered;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idOrder) {
        this.id = idOrder;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getDelivered() {
        return isDelivered;
    }

    public void setDelivered(Boolean delivered) {
        isDelivered = delivered;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                idUser.equals(order.idUser) &&
                date.equals(order.date) &&
                isDelivered.equals(order.isDelivered) &&
                totalPrice.equals(order.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", date=" + date +
                ", isDelivered=" + isDelivered +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

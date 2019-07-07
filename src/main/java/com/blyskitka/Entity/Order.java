package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    Integer idOrder;
    Integer idUser;
    LocalDate date;
    Boolean isDelivered;
    Double price;

    public Order() {
    }

    public Order(Integer idOrder, Integer idUser, LocalDate date, Boolean isDelivered, Double price) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.date = date;
        this.isDelivered = isDelivered;
        this.price = price;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idOrder.equals(order.idOrder) &&
                idUser.equals(order.idUser) &&
                date.equals(order.date) &&
                isDelivered.equals(order.isDelivered) &&
                price.equals(order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idUser, date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", date=" + date +
                ", isDelivered=" + isDelivered +
                ", price=" + price +
                '}';
    }
}

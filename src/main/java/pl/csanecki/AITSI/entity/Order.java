package pl.csanecki.AITSI.entity;

import pl.csanecki.AITSI.entity.embedded.Address;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDER")
public class Order {
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "USER_EMAIL")

    @Embedded
    private Address address;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    public Order(int orderId, Address address, Date orderDate) {
        this.orderId = orderId;
        this.address = address;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", address=" + address +
                ", orderDate=" + orderDate +
                '}';
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}

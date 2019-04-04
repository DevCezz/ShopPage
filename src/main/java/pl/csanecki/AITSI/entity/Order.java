package pl.csanecki.AITSI.entity;

import org.springframework.web.context.request.RequestContextHolder;
import pl.csanecki.AITSI.entity.embedded.Address;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ORDER_CART")
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    private String orderId;

    @Transient
    private Set<OrderProduct> orderProducts;

    @Column(name = "SUM_OF_ORDER")
    private Double sum;

    @Column(name = "DATE_ORDER")
    private Date orderDate;

    @Embedded
    private Address address;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    public Order() {
        this.orderId = RequestContextHolder.currentRequestAttributes().getSessionId();
        this.orderProducts = new LinkedHashSet<>();
        this.sum = 0.0;
        this.orderDate = new Date();
    }

    public Order(Set<OrderProduct> orderProducts, Double sum, Date orderDate) {
        this.orderProducts = orderProducts;
        this.sum = sum;
        this.orderDate = orderDate;
    }

    public void addProductWithAmount(Product product, int amount) {
        OrderProduct orderProduct = new OrderProduct(product, amount);
        
        if(this.orderProducts.contains(orderProduct)) {
            for (OrderProduct orderProductInSet : this.orderProducts) {
                if (orderProductInSet.equals(orderProduct))
                    orderProductInSet.addAmount(amount);
            }
        } else {
            orderProducts.add(orderProduct);        	
        }
    }
    
    public int getAmountOfProductInCart(Product product) {
        for (OrderProduct orderProduct : this.orderProducts) {
            if (orderProduct.getProduct().equals(product))
                return orderProduct.getAmount();
        }
    	
    	return 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderProducts=" + orderProducts +
                ", sum=" + sum +
                ", orderDate=" + orderDate +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}

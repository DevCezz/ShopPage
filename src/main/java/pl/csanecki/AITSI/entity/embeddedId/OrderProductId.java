package pl.csanecki.AITSI.entity.embeddedId;

import pl.csanecki.AITSI.entity.Order;
import pl.csanecki.AITSI.entity.Product;

import javax.persistence.*;

@Embeddable
public class OrderProductId {
    @ManyToOne
    @Column(name = "ORDER_ID")
    @JoinColumn(name = "orderId")
    private Order order;

    @OneToOne
    @Column(name = "PRODUCT_ID")
    @JoinColumn(name = "productId")
    private Product product;

    public OrderProductId(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderProductId{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

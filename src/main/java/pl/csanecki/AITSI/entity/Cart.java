package pl.csanecki.AITSI.entity;

import org.springframework.web.context.request.RequestContextHolder;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Cart {
    private String cartId;
    private Set<OrderProduct> orderProducts;
    private Double sum;
    private Date orderDate;

    public Cart() {
        this.cartId = RequestContextHolder.currentRequestAttributes().getSessionId();
        this.orderProducts = new LinkedHashSet<>();
        this.sum = 0.0;
        this.orderDate = new Date();
    }

    public Cart(Set<OrderProduct> orderProducts, Double sum, Date orderDate) {
        this.orderProducts = orderProducts;
        this.sum = sum;
        this.orderDate = orderDate;
    }

    public void addProductWithAmount(Product product, int amount) {
        OrderProduct orderProduct = new OrderProduct(product, amount);
        
        if(this.orderProducts.contains(orderProduct)) {
        	for (Iterator<OrderProduct> it = this.orderProducts.iterator(); it.hasNext(); ) {
        		OrderProduct f = it.next();
                if (f.equals(orderProduct))
                    f.addAmount(amount);
            }
        	orderProduct.addAmount(amount);
        } else {
            orderProducts.add(orderProduct);        	
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", orderProducts=" + orderProducts +
                ", sum=" + sum +
                ", orderDate=" + orderDate +
                '}';
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
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

package pl.csanecki.AITSI.entity;

import pl.csanecki.AITSI.entity.embeddedId.OrderProductId;

import javax.persistence.*;

@Entity
@Table(name = "ORDERED_PRODUCT")
public class OrderProduct {
    @EmbeddedId
    private OrderProductId orderProductId;

    @Column(name = "ORDERED_AMOUNT")
    private int amount;

    public OrderProduct(OrderProductId orderProductId, int amount) {
        this.orderProductId = orderProductId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderProductId=" + orderProductId +
                ", amount=" + amount +
                '}';
    }

    public OrderProductId getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(OrderProductId orderProductId) {
        this.orderProductId = orderProductId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderProductId.getProduct() == null) ? 0 : orderProductId.getProduct().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProduct other = (OrderProduct) obj;
		if (orderProductId.getProduct() == null) {
			if (other.orderProductId.getProduct() != null)
				return false;
		} else if (!orderProductId.getProduct().equals(other.orderProductId.getProduct()))
			return false;
		return true;
	}
}

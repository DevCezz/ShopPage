package pl.csanecki.AITSI.entity;

public class OrderProduct {
    private Product product;
    private int amount;

    public OrderProduct(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "product=" + product +
                ", amount=" + amount +
                '}';
    }

    public void addAmount(int additionAmount) {
    	this.amount += additionAmount;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}

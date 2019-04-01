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
}

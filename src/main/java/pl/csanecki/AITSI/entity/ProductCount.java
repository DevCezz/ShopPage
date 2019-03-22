package pl.csanecki.AITSI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_COUNT", schema = "AITSI")
public class ProductCount {
	@Id
	@Column(name = "PRODUCT_ID")
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Product product;

	@Column(name = "AVAILABLE_AMOUNT")
	private int avaiableAmount;
	
	@Column(name = "PEOPLE_BOUGHT")
	private int peopleBought;
	
	@Column(name = "ITEM_BOUGHT")
	private int itemBought;
	
	@Override
	public String toString() {
		return "ProductCount [product=" + product + ", avaiableAmount=" + avaiableAmount +
				", peopleBought=" + peopleBought + ", itemBought=" + itemBought + "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAvaiableAmount() {
		return avaiableAmount;
	}

	public void setAvaiableAmount(int avaiableAmount) {
		this.avaiableAmount = avaiableAmount;
	}

	public int getPeopleBought() {
		return peopleBought;
	}

	public void setPeopleBought(int peopleBought) {
		this.peopleBought = peopleBought;
	}

	public int getItemBought() {
		return itemBought;
	}

	public void setItemBought(int itemBought) {
		this.itemBought = itemBought;
	}
}

package pl.csanecki.AITSI.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "PRODUCT_COUNT")
public class ProductCount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_COUNT_ID")
	private long productCountId;

	@Min(value = 0, message = "* Proszę wprowadź liczbę nieujemną dostępnej ilości produktu")
	@Pattern(regexp = "[\\d]{10}", message = "* Proszę wprowadzać tylko liczby (do 10 znaków)")
	@Column(name = "AVAILABLE_AMOUNT")
	private int availableAmount;
	
	@Column(name = "PEOPLE_BOUGHT")
	private int peopleBought;
	
	@Column(name = "ITEM_BOUGHT")
	private int itemBought;

	public ProductCount() {
		this.peopleBought = 0;
		this.itemBought = 0;
	}

	@Override
	public String toString() {
		return "ProductCount{" +
				"productCountId=" + productCountId +
				", availableAmount=" + availableAmount +
				", peopleBought=" + peopleBought +
				", itemBought=" + itemBought +
				'}';
	}

	public long getProductCountId() {
		return productCountId;
	}

	public void setProductCountId(long productCountId) {
		this.productCountId = productCountId;
	}

	public int getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
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

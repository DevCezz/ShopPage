package pl.csanecki.AITSI.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT", schema = "AITSI")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private long productId;
	
	@Column(name = "PRODUCER")
	private String producer;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRIZE")
	private double prize;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productTypeId")
	private ProductType productType;

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", producer='" + producer + '\'' +
				", model='" + model + '\'' +
				", description='" + description + '\'' +
				", prize=" + prize +
				", productType=" + productType +
				'}';
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
}














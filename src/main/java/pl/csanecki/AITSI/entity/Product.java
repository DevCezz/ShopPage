package pl.csanecki.AITSI.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private long productId;
	
	@Column(name = "PRODUCER")
	@NotEmpty(message = "* Proszę podaj nazwę producenta")
	@Length(min = 2, max = 50, message = "* Proszę podaj nazwę producenta zawierającą od 2 do 50 znaków")
	private String producer;

	@Column(name = "MODEL")
	@Length(min = 2, max = 100, message = "* Proszę podaj model zawierający od 2 do 100 znaków")
	@NotEmpty(message = "* Proszę podaj nazwę producenta")
	private String model;

	@Column(name = "DESCRIPTION")
	@Length(max = 1000, message = "* Opis nie może być dłuższy niż 1000 znaków")
	private String description;

	@Column(name = "PRIZE")
	@DecimalMin(value = "0.01", message = "* Proszę wprowadź cenę produktu")
	@Digits(integer = 10, fraction = 2, message = "* Proszę wprowadź cenę do 2 miejsc po przecinku")
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














package pl.csanecki.AITSI.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AITSI.PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private long id;
	
	@Column(name = "PRODUCER")
	private String producer;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRIZE")
	private double prize;
	
	@Column(name = "PRODUCT_TYPE_ID")
	private ProductType productType;
	
}














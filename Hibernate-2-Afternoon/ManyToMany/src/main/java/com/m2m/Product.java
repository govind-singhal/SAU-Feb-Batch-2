package com.m2m;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	private int productId;
	private String productName;
	
	@ManyToOne
	private Categories category;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Product(int productId, String productName, Categories category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

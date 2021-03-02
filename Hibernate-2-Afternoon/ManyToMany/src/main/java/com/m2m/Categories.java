package com.m2m;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Categories {
	
	@Id
	private int categoryId;
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	private List<Product> product;
	
	@ManyToMany(mappedBy = "categories")
	private List<Supplier> suppliers;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Categories(int categoryId, String categoryName, List<Product> product, List<Supplier> suppliers) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.product = product;
		this.suppliers = suppliers;
	}

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

package com.m2m;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Supplier {
	
	@Id
	private int supplierId;
	private String supplierName;
	
	
	@ManyToMany
	private List<Categories> categories;


	public int getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public List<Categories> getCategories() {
		return categories;
	}


	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}


	public Supplier(int supplierId, String supplierName, List<Categories> categories) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.categories = categories;
	}


	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

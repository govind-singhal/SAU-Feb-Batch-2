package com.kafka;


public class Order {
	private int id;
	private int quantity;
	private String type;
	private String date;
	public Order() {
		
	}
	
	public Order(int id, int quantity, String type, String date) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.type = type;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", quantity=" + quantity + ", type=" + type + ", date=" + date + "]";
	}
	
	

}

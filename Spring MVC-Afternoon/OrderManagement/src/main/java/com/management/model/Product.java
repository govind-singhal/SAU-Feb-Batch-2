package com.management.model;

public class Product {
    private int pId;
    private long price;
    private String name;


    public int getId() {
        return pId;
    }

    public void setId(int id) {
        this.pId = id;
    }

    public long getCost() {
        return price;
    }

    public void setCost(long cost) {
        this.price = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

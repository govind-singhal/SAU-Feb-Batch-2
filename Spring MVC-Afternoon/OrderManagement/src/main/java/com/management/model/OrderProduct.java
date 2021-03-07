package com.management.model;

public class OrderProduct {
    private int id;
    private int units;
    private Product item;
    private long totalCost;


    public long getTotalCost() {
        return totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost += totalCost;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }
}
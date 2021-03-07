package com.management.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private int id;
    private long totalOrderCost;
    private String customerName;
    private HashMap<Integer, OrderProduct> itemsList = new HashMap<>();

    public boolean addItem(OrderProduct item){
        item.setTotalCost(item.getUnits() * item.getItem().getCost());
        itemsList.put(item.getId(), item);
        this.totalOrderCost += item.getTotalCost();
        return true;
    }

    public List<OrderProduct> getItemsList() {
        List<OrderProduct> items = new ArrayList<>();
        for(Map.Entry<Integer, OrderProduct> entry : itemsList.entrySet()){
            items.add(entry.getValue());
        }
        return items;
    }

    public boolean removeItem(int itemId){
        if(itemsList.containsKey(itemId)){
            this.totalOrderCost -= itemsList.get(itemId).getTotalCost();
            itemsList.remove(itemId);
            return true;
        }
        return false;
    }

    public OrderProduct updateOrderItem(int itemId, OrderProduct item){
        if(itemsList.containsKey(itemId)) {
            this.totalOrderCost -= itemsList.get(itemId).getTotalCost();
            int id = itemsList.get(itemId).getId();
            item.setId(id);
            item.setTotalCost(item.getUnits() * item.getItem().getCost());
            itemsList.put(itemId, item);
            this.totalOrderCost += item.getTotalCost();
            return item;
        }
        return null;
    }

    public long getTotalOrderCost() {
        return totalOrderCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

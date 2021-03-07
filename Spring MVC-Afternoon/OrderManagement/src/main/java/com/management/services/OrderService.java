package com.management.services;

import com.management.model.Order;
import com.management.model.OrderProduct;
import com.management.model.OrdersManagement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private int lastOrderIdGiven;
    private int lastItemIdGiven;
    private OrdersManagement orders;

    public OrderService(){
        this.lastOrderIdGiven = 0;
        this.lastItemIdGiven = 0;
        orders = new OrdersManagement();
    }

    public Order createOrder(Order order){
        order.setId(++lastItemIdGiven);
       // orders.setOrdersList(order);
        return order;
    }

    public List<Order> getAllOrders(){
        return orders.getOrdersList();
    }

    public Order addItemToOrder(int orderId, OrderProduct item){
        Order currentOrder = orders.getOrder(orderId);
        item.setId(++lastOrderIdGiven);
        if(currentOrder.addItem(item)) {
            return currentOrder;
        }
        return null;
    }

    public List<OrderProduct> getOrderItems(int orderId){
        Order currentOrder = orders.getOrder(orderId);
        return currentOrder.getItemsList();
    }

    public boolean checkOrderItem(int orderId){
        Order currentOrder = orders.getOrder(orderId);
        if(currentOrder == null){
            return false;
        }
        return true;
    }

    public boolean removeItemFromOrder(int orderId, int itemId){
        Order currentOrder = orders.getOrder(orderId);
        return currentOrder.removeItem(itemId);
    }

    public OrderProduct updateItem(int itemId, int orderId, OrderProduct item){
        Order currentOrder = orders.getOrder(orderId);
        item.setId(++lastOrderIdGiven);
        return currentOrder.updateOrderItem(itemId, item);
    }

    public boolean removeOrder(int orderId){
        return orders.removeOrder(orderId);
    }
}

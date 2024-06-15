package com.bookstore.inventory.dto;

import java.util.List;

import com.bookstore.inventory.entity.Order;

public interface OrderDAO {
	
	List<Order> getAllOrders();
    Order getOrderById(Long id);
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(Long id);

}

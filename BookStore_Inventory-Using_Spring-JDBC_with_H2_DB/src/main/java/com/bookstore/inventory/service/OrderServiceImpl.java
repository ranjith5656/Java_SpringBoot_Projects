package com.bookstore.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.inventory.dto.OrderDAO;
import com.bookstore.inventory.entity.Order;

public class OrderServiceImpl {
	 @Autowired
	private OrderDAO orderDAO;

    

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public Order getOrderById(Long id) {
        return orderDAO.getOrderById(id);
    }

    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(Long id) {
        orderDAO.deleteOrder(id);
    }

}

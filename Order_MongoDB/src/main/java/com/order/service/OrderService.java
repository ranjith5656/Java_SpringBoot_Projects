package com.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.entity.Order;

@Service
public interface OrderService {	
	
	public Order creatOrder(Order book);

	public Order updateOrder(Long bookId, Order book);

	public Order getOrderById(Long OrderId);

	public Order getOrderByStatus(String OrderStatus);

	public void deleteOrderById(Long bookId);

	public List<Order> getAllOrders();

}

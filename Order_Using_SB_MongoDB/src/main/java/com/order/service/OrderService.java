package com.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.domain.OrderDomain;

@Service
public interface OrderService {

	public OrderDomain creatOrder(OrderDomain book);

	public OrderDomain updateOrder(Long bookId, OrderDomain book);

	public OrderDomain getOrderById(Long OrderId);

	public OrderDomain getOrderByStatus(String OrderStatus);

	public void deleteOrderById(Long bookId);

	public List<OrderDomain> getAllOrders();

	public List<OrderDomain> getAllOrdersWithPagination(Integer offset, Integer limit);
}

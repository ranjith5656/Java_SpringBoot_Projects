package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
//	@Autowired
//    private IdGenerator idGenerator;

	@Override
	public Order creatOrder(Order order) {
		//order.setOrderId(idGenerator.generateId());
		return orderRepository.save(order);
	}

	public Order updateOrder(Long orderId, Order order) {
		Order existingOrders = orderRepository.findByOrderId(orderId);
		if (existingOrders != null) {
			existingOrders.setOrderStatus(order.getOrderStatus());

			return orderRepository.save(existingOrders);
		}
		return null;
	}

	public Order getOrderById(Long bookId) {

		Order getOrder = orderRepository.findByOrderId(bookId);
		if (getOrder != null) {
			return getOrder;
		}
		return null;
	}

	/**
	 * Deletes a book based on its unique ID.
	 *
	 * @param bookId The ID of the book to delete.
	 */
	public void deleteOrderById(Long OrderId) {
		orderRepository.deleteById(OrderId);
	}

	public List<Order> getAllOrders() {

		List<Order> eventsList = new ArrayList<Order>();
		List<Order> entityList = orderRepository.findAll();
		if (entityList.size() > 0) {
			for (Order entity : entityList) {
				eventsList.add(entity);
			}
		}
		return eventsList;
	}

	public Order getOrderByStatus(String OrderStatus) {
		Order getOrderName = orderRepository.findByOrderStatus(OrderStatus);
		if (getOrderName != null) {
			return getOrderName;
		}
		return null;
	}

}

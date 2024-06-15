package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.order.domain.OrderDomain;
import com.order.entity.Order;
import com.order.objectcopier.ObjectCopier;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDomain creatOrder(OrderDomain orderDomain) {
		Order entity = toEntity(orderDomain);
		entity = orderRepository.save(entity);
		return toDomain(entity);
	}

	public OrderDomain updateOrder(Long bookId, OrderDomain orderDomain) {
		Order existingOrders = orderRepository.findByOrderId(bookId);
		if (existingOrders != null) {
			existingOrders.setOrderStatus(orderDomain.getOrderStatus());

			return toDomain(orderRepository.save(existingOrders));
		}
		return null;
	}

	public OrderDomain getOrderById(Long bookId) {

		Order getOrder = orderRepository.findByOrderId(bookId);
		if (getOrder != null) {
			return toDomain(getOrder);
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

	public List<OrderDomain> getAllOrders() {

		List<OrderDomain> eventsList = new ArrayList<OrderDomain>();
		List<Order> entityList = orderRepository.findAll();
		if (entityList.size() > 0) {
			for (Order entity : entityList) {
				eventsList.add(toDomain(entity));
			}
		}
		return eventsList;
	}

	public List<OrderDomain> getAllOrdersWithPagination(Integer offset, Integer limit) {
		Pageable pageable = PageRequest.of(--offset, limit);
		Page<com.order.entity.Order> page = orderRepository.findAll(pageable);
		List<OrderDomain> bookDomainList = new ArrayList<OrderDomain>();
		for (com.order.entity.Order bookDetail : page) {
			OrderDomain domain = toDomain(bookDetail);
			domain.setTotalRecords(page.getTotalElements());
			bookDomainList.add(domain);
		}
		return bookDomainList;
	}

	public OrderDomain getOrderByStatus(String OrderStatus) {
		Order getOrderName = orderRepository.findByOrderStatus(OrderStatus);
		if (getOrderName != null) {
			return toDomain(getOrderName);
		}
		return null;
	}

	/**
	 * Converts a BookDomain object to a Book entity.
	 *
	 * @param domain The BookDomain object to convert.
	 * @return The corresponding Book entity.
	 */

	private com.order.entity.Order toEntity(OrderDomain domain) {
		com.order.entity.Order entity = new com.order.entity.Order();
		ObjectCopier.copyObject(domain, entity);
		return entity;
	}

	private OrderDomain toDomain(com.order.entity.Order entity) {
		OrderDomain domain = new OrderDomain();
		ObjectCopier.copyObject(entity, domain);
		return domain;
	}

}

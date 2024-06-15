package com.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Long>{
	
	public Order findByOrderId(Long orderId);

	public Order findByOrderStatus(String oderStatus);

}

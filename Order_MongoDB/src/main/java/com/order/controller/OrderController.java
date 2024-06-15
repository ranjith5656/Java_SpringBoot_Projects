package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping()
	public Order addOrder(@RequestBody Order order) {
		Order orders = orderService.creatOrder(order);
		return orders;
	}
	
	@GetMapping()
	public List<Order> fetchAllOrders(){
		return orderService.getAllOrders();
	}

}

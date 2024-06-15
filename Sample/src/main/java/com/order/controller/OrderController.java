package com.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@GetMapping(value = "/orders")
	public String getorders() {
		return "orders";
	}

}

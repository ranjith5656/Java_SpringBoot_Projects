package com.order.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="order")
public class Order {
	
	@Id
    private Long orderId;	
	
	private String orderStatus;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Order(Long orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
	}
	
	
	

}

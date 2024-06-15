package com.order.domain;

import java.io.Serializable;




public class OrderDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long orderId;
	
	private String orderStatus;
	
     private Long totalRecords;

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

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	

}

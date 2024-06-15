package com.bookstore.inventory.entity;

import java.util.List;

public class Order {
    private Long id;
    private Long customerId; // ID of the customer who placed the order
    private List<Book> books;
    private String customerName; // Name of the customer who placed the order
    private String shippingAddress; // Shipping address for the order
    private double totalAmount; // Total amount of the order
   
 // Getters and Setters for the new attributes
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getTotalAmount() {
        return totalAmount;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
    public Order(Long id, Long customerId, List<Book> books, String customerName, String shippingAddress, double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.books = books;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.totalAmount = totalAmount;
    }

    
    
}
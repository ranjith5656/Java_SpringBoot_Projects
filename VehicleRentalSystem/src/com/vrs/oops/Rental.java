package com.vrs.oops;

import java.time.LocalDateTime;

public class Rental {

	private int id;
	private Vehicle rentedVehicle;
	private Customer customer;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public Vehicle getRentedVehicle() {
		return rentedVehicle;
	}

	public void setRentedVehicle(Vehicle rentedVehicle) {
		this.rentedVehicle = rentedVehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//	public boolean isOngoing() {
//	        LocalDateTime currentTime = LocalDateTime.now();
//	        return startTime.isBefore(currentTime) && endTime.isAfter(currentTime);
//	    }
//
//	    public boolean isExpired() {
//	        LocalDateTime currentTime = LocalDateTime.now();
//	        return endTime.isBefore(currentTime);
//	    }

}

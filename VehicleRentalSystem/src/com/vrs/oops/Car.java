package com.vrs.oops;

public class Car extends Vehicle {

	private int numberOfSeats = 5;
	private String fuelType = "Petrol";

	// Getters and setters for Car-specific properties
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Car [numberOfSeats=" + numberOfSeats + ", fuelType=" + fuelType + "]";
	}

}

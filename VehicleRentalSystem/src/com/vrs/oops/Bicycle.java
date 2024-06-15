package com.vrs.oops;

public class Bicycle extends Vehicle {
	
	// Attributes or Properties
    private String Made = "India";
    private boolean hasBasket = false;

    

    // Getters and setters
    public boolean hasBasket() {
        return hasBasket;
    }

    public void setHasBasket(boolean hasBasket) {
        this.hasBasket = hasBasket;
    }

	public String getMade() {
		return Made;
	}

	public void setMade(String made) {
		Made = made;
	}

	public boolean isHasBasket() {
		return hasBasket;
	}

	@Override
	public String toString() {
		return "Bicycle [Made=" + Made + ", hasBasket=" + hasBasket + "]";
	}

	
	
}





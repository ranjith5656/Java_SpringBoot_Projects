package com.vrs.oops;

public class Motorcycle extends Vehicle {
	
	private String engineCapacity = "100 cc";

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	@Override
	public String toString() {
		return "Motorcycle [engineCapacity=" + engineCapacity + "]";
	}

    
    
   

}

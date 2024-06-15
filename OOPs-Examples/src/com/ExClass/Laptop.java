package com.ExClass;

public class Laptop {

	public static void main(String[] args) {

		DellLaptop dell = new DellLaptop();
		dell.performance();
		dell.processing();
		
		HpLaptop hp = new HpLaptop();
		hp.performance();
		hp.processing();
	}

}

package com.inheritance;

class Calculation {
	
	int z;
	
	public void addition(int x, int y) {
		
		z = x + y;
		System.out.println("Sum of given two numbers: "+z);
	}
	
	public void substraction(int x, int y) {
		
		z = x - y;
		System.out.println("Substraction of given two numbers: "+z);
		
	}
}

public class MainCalculation extends Calculation{
		
		public void multiple(int x, int y) {
			z = x * y;
			System.out.println("Multiplication of given two numbers: "+z);
		}
		
		public static void main(String[] args) {
			
			int a = 26;
			int b = 56;
			MainCalculation cal = new MainCalculation();
			
			cal.addition(a, b);
			cal.substraction(a, b);
			cal.multiple(a, b);
		}
	

}

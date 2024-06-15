package com.practice;

import java.util.Scanner;

public class SwapTwoNumbers {
	
	public static void main(String[] args) {
		
		/*
		 * int x = 56; int y = 78; int temp;
		 * 
		 * System.out.println("Before Swapping x is "+ x + " y is "+ y);
		 * 
		 * temp = x; x = y; y = temp;
		 * 
		 * System.out.println("After Swapping x is "+ x + " y is "+ y);
		 */
		
		/*
		 * int x, y,temp;
		 * 
		 * System.out.println("Enter X and Y: ");
		 * 
		 * Scanner src = new Scanner(System.in);
		 * 
		 * x = src.nextInt(); y = src.nextInt();
		 * 
		 * System.out.println("Before Swapping x is "+x +" y is " +y); temp = x; x = y;
		 * y = temp; System.out.println("After Swapping x is "+x +" y is " +y);
		 */
		
		// without using third variable 
		
		int i = 46;
		int j = 96;
		
		System.out.println("Before swapping is x "+i+" y is "+j);
		
		i = i+j;
		j = i-j;
		i = i-j;
		
		System.out.println("After swapping is x "+i+" y is "+j);
		
		
	}
	
	
	

}

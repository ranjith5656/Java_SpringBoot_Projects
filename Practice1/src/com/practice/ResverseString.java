package com.practice;

public class ResverseString {
	
	public static void main(String[] args) {
		
		String str = "Ranjith";
		
		StringBuilder str1 = new StringBuilder();
		
		str1.append(str);
		
		str1 = str1.reverse();
		
		System.out.println(str1);
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
@SpringBootApplication
public class CollectionPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectionPracticeApplication.class, args);
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("Ravi"); 
		list.add("Vijay");  
		list.add("Ravi");  
		list.add("Ajay");  
		
		Iterator itr=list.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
	}

}

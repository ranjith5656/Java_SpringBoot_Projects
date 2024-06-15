package cursors;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++)
			arrayList.add(i);

		System.out.println(arrayList);

		Iterator<Integer> itr = arrayList.iterator();

		while (itr.hasNext()) {
			int i = itr.next();

			System.out.print(i + " ");

			if (i % 2 != 0)
				itr.remove();
		}

		System.out.println();

		System.out.println(arrayList);
	}

}







































//package com.example.bookstore.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/customer/**").hasRole("CUSTOMER")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout()
//                .and()
//                .csrf().disable();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("{noop}admin").roles("ADMIN")
//                .and()
//                .withUser("user").password("{noop}user").roles("CUSTOMER");
//    }
//}


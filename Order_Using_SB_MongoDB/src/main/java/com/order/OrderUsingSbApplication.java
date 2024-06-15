package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages={"com.*"})
@EntityScan( basePackages = {"com.*"} )
@EnableMongoRepositories( basePackages = {"com.*"} )
public class OrderUsingSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderUsingSbApplication.class, args);
	}

}

package com.aquent.order;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderSortingApplication extends FatJarRouter {

	public static void main(String[] args) {
		SpringApplication.run(OrderSortingApplication.class, args);
	}


}

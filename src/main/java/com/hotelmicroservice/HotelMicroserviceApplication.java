package com.hotelmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@PropertySource(value="classpath:/profiles/${spring.profiles.active}/application.properties")
public class HotelMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelMicroserviceApplication.class, args);
		
		System.out.println("Hello Hotel Microservice");
	}

}

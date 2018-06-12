package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	public TestGatewayFilterFactory testGatewayFilterFactory() {
		return new TestGatewayFilterFactory();
	}

//	@Bean
//	public RemoveForwardedGatewayFilterFactory removeForwardedGatewayFilterFactory() {
//		return new RemoveForwardedGatewayFilterFactory();
//	}

}
package com.ani.gatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
		        .route(p -> p
		            .path("/customer/**")
		            .uri("lb://CUSTOMER-DETAILS"))
		        .route(p -> p
		            .path("/oms/**")
		            .uri("lb://ORDER-MANAGEMENT"))
		        .route(p -> p
			            .path("/seller/**")
			            .uri("lb://SELLER-PORTAL"))
		        .build();
	}

}

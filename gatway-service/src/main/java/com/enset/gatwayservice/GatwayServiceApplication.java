package com.enset.gatwayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class GatwayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatwayServiceApplication.class, args);
	}


	@Bean
	DiscoveryClientRouteDefinitionLocator routes(ReactiveDiscoveryClient ds,
												 DiscoveryLocatorProperties p) {
		return new DiscoveryClientRouteDefinitionLocator(ds, p);
	}
}

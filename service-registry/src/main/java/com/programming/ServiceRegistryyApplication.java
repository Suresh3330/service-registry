package com.programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryyApplication.class, args);
		System.out.println("Service-Registry is running");
	}

}

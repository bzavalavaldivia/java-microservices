package com.ms.motorcycles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsMotorcyclesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMotorcyclesApplication.class, args);
	}

}

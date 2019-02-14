package com.stackroute.plasma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NlpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NlpServiceApplication.class, args);
	}

}


package com.stackroute.taggingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class TaggingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaggingServiceApplication.class, args);
	}

}

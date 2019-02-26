package com.stackroute.knowledgequeryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KnowledgeQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgeQueryServiceApplication.class, args);
	}

}

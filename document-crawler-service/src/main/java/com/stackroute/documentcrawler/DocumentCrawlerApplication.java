package com.stackroute.documentcrawler;

import com.stackroute.documentcrawler.controller.DocumentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.text.Document;


@EnableAutoConfiguration
@SpringBootApplication

public class DocumentCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentCrawlerApplication.class, args);
	}

}


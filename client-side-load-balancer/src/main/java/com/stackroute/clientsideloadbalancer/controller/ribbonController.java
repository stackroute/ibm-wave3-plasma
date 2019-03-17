package com.stackroute.clientsideloadbalancer.controller;

import com.stackroute.clientsideloadbalancer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientName;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name="zuul-service")
public class ribbonController {

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/nlp")
    public String nlpService(){
        return  this.restTemplate.getForObject(
                "http://zuul-service/nlp-service", String.class);
    }

    @PostMapping("/user-login-service/userAuth")
    public String userLogin(){
        return  this.restTemplate.getForObject(
                "http://zuul-service/user-login-service/userAuth", String.class);
    }

    @PostMapping("/user-register-service")
    public ResponseEntity<?> userRegister(@RequestBody User user){
        //this.restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        this.restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<>(this.restTemplate.postForObject(
                "http://zuul-service/user-register-service", user , User.class), HttpStatus.CREATED);
        return responseEntity;
    }


    @PostMapping("/search")
    public String searchService(){
        return  this.restTemplate.getForObject(
                "http://zuul-service/search-service", String.class);
    }

    /* or alternative option */
    /* and add localhost:8071/nameoftheservice */
    /* try this */
    @RequestMapping("/zuul-service/{serviceName}")
    public String serviceLocator(@PathVariable("serviceName")String serviceName){
        return  this.restTemplate.getForObject(
                "http://zuul-service/" + serviceName, String.class);
    }


}


/*
@RibbonClient(name = "api-gateway")//, configuration = RibbonConfiguration.class)
class ServerLocationApp {

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/micro")
	public String serverLocation() {
		return  this.restTemplate.getForObject(
				"http://api-gateway/microservice", String.class);
	}
	@RequestMapping("/zuul")
	public String zuulLocation() {
		return  this.restTemplate.getForObject(
				"http://api-gateway/", String.class);
	}
}

* */
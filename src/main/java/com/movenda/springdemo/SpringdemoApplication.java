package com.movenda.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringdemoApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringdemoApplication.class, args);
    }

    @GetMapping
    public String getMapping() {
	return "Get request mapped!";
    }

}

/*
 * @RestController fa si che la classe possa rendere disponibili endpoint
 * restful
 * 
 */
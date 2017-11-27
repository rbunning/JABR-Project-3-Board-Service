package com.revature.project3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BoardCommentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardCommentServiceApplication.class, args);
	}
}

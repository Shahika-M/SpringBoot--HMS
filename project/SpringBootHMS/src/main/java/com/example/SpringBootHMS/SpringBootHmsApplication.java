package com.example.SpringBootHMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("com.example.SpringBootHMS")
//@EntityScan("com.example.SpringBootHMS")
//@EnableJpaRepositories("com.example.SpringBootHMS")
public class SpringBootHmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHmsApplication.class, args);
	}

}

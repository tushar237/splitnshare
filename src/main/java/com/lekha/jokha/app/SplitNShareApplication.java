package com.lekha.jokha.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lekha.jokha"})
@EnableJpaRepositories(basePackages = {"com.lekha.jokha"})
@EntityScan(basePackages = {"com.lekha.jokha"})
public class SplitNShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitNShareApplication.class, args);
	}
}

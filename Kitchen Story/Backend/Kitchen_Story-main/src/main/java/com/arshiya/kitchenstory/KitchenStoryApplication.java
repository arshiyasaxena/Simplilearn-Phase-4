package com.arshiya.kitchenstory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.arshiya.kitchenstory.repository")
public class KitchenStoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchenStoryApplication.class, args);
	}

}

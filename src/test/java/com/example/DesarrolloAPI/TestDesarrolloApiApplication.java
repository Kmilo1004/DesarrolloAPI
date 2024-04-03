package com.example.DesarrolloAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;


@TestConfiguration(proxyBeanMethods = false)
public class TestDesarrolloApiApplication {

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgreSQLContainer(){

		return new PostgreSQLContainer<>("postgres:15-alpine");
	}

	public static void main(String[] args) {
		SpringApplication
				.from(DesarrolloApiApplication::main)
				.with(TestDesarrolloApiApplication.class)
				.run(args);
	}
}

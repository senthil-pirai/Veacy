package com.pirai.user.controller.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class UserConfig {

	@Bean
	public OpenAPI api() {
		
		Info info = new Info();
		info.title("User table Swagger")
		.description("User table CURD operations")
		.version("2.0");
		
		Server localServer = new Server();
		localServer.url("http://localhost:8080");
		localServer.description("Server URL in Local environment");

		Server productionServer = new Server();
		productionServer.setUrl("http://production.com");
		productionServer.setDescription("Server URL in Production environment");
		
		Server devServer = new Server();
		devServer.url("https://dev.com");
		devServer.description("Server URL in dev environment");
		
		return new OpenAPI().info(info)
				.servers(List.of(localServer,productionServer,devServer));
	}
}

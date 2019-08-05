package com.manash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean("webClient")
	public WebClient createWebClient() {
		return  WebClient.create("http://localhost:9091");
		
	}
}


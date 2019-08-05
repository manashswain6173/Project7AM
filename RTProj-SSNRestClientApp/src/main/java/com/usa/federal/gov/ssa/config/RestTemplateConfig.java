package com.usa.federal.gov.ssa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Bean("restTemp")
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
}

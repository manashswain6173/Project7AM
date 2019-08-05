package com.manash.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.manash.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class JunitTestApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(JunitTestApp1Application.class, args);
	}

}

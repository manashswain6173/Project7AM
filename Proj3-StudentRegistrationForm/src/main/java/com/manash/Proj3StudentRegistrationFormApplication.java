package com.manash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.manash.config.AppConfig;
import com.manash.config.WebMvcConfig;

@SpringBootApplication
//@Import({WebMvcConfig.class,AppConfig.class})
public class Proj3StudentRegistrationFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj3StudentRegistrationFormApplication.class, args);
	}

}

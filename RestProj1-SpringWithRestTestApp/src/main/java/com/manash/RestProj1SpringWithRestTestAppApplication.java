package com.manash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.manash.resources.UserRestResource;

@SpringBootApplication
@Import(UserRestResource.class)
public class RestProj1SpringWithRestTestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestProj1SpringWithRestTestAppApplication.class, args);
	}

}

package com.manash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.manash.config.AppsConfig;
import com.manash.config.WebMvcConfig;


@SpringBootApplication
@Import({WebMvcConfig.class,AppsConfig.class})
public class BootProj4RestClientForStudentRegFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProj4RestClientForStudentRegFormApplication.class, args);
	}

}

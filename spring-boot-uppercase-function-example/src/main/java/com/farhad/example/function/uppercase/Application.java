package com.farhad.example.function.uppercase;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {


	@Bean
	public Function<String,String> uppercase() {
		return s -> s.toUpperCase() ;
	}

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// SpringApplication.run(FunctionSampleApplication.class, "--management.endpoints.web.exposure.include=functions");
		
	}

}

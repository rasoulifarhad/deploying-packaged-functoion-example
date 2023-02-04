package com.farhad.example.function;


import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.farhad.example.function.reverse.ReverseFunction;
import com.farhad.example.function.uppercase.UppercaseFunction;

@SpringBootApplication
public class Application {



	 public static void main(String[] args) {
	 	SpringApplication.run(Application.class, args);
	 	// SpringApplication.run(FunctionSampleApplication.class, "--management.endpoints.web.exposure.include=functions");
		
	 }


	 @Bean
	 public UppercaseFunction uppercase() {
		return new UppercaseFunction();
	 }

	 @Bean
	 public ReverseFunction reverse() {
		return new ReverseFunction();
	 }

}

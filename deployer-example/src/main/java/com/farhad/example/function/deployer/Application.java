package com.farhad.example.function.deployer;


import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import  org.springframework.context.ApplicationContext;
// import  org.springframework.cloud.function.context.FunctionCatalog; 

@SpringBootApplication
public class Application {



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// SpringApplication.run(FunctionSampleApplication.class, "--management.endpoints.web.exposure.include=functions");
		
	}

	// public static void main(String[] args) {
	// 	ApplicationContext context =  SpringApplication.run(Application.class, 
	// 							"--spring.cloud.function.location=/home/farhad/apps/my-examples/spring-cloud-function/deploying-packaged-functoion-example/normal-uppercase-function-example/target/normal-uppercase-function-example-0.0.1-SNAPSHOT.jar",
	// 							"--spring.cloud.function.function-class=com.farhad.example.function.uppercase.UppercaseFunction;com.farhad.example.function.uppercase.ReverseFunction");
	// 	FunctionCatalog catalog = context.getBean(FunctionCatalog.class);
	// 	Function<String,String> uppercaseFunction =  catalog.lookup("uppercaseFunction");
	// 	Function<String,String> reverseFunction =  catalog.lookup("reverseFunction");

	// 	System.out.println(uppercaseFunction.apply("Hello"));
	// 	System.out.println(reverseFunction.apply("Hello"));

		
	// } 

}

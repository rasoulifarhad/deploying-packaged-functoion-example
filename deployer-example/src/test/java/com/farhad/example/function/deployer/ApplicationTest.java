package com.farhad.example.function.deployer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import reactor.core.publisher.Flux;

import org.springframework.context.ApplicationContext;

import  org.springframework.cloud.function.context.FunctionCatalog;

import java.util.List;
import java.util.function.Function;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {


   @Test 
   public void  testUpperCaseFunction() {

        String [] args = new String [] {
								"--spring.cloud.function.location=/home/farhad/apps/my-examples/spring-cloud-function/deploying-packaged-functoion-example/normal-uppercase-function-example/target/normal-uppercase-function-example-0.0.1-SNAPSHOT.jar",
								"--spring.cloud.function.function-class=com.farhad.example.function.uppercase.UppercaseFunction;com.farhad.example.function.uppercase.ReverseFunction"
        };
        ApplicationContext context = SpringApplication.run(Application.class, args);
           
        FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
        Function<String,String> uppercaseFunction = functionCatalog.lookup("uppercaseFunction");

        assertThat(uppercaseFunction.apply("Hello")).isEqualTo("HELLO");

    } 

    @Test
    public void testReverseFunction() {

        String[] args = new String[] {
            "--spring.cloud.function.location=/home/farhad/apps/my-examples/spring-cloud-function/deploying-packaged-functoion-example/normal-uppercase-function-example/target/normal-uppercase-function-example-0.0.1-SNAPSHOT.jar",
            "--spring.cloud.function.function-class=com.farhad.example.function.uppercase.UppercaseFunction;com.farhad.example.function.uppercase.ReverseFunction"
        };

       try (ConfigurableApplicationContext context = 
                           new SpringApplicationBuilder(Application.class)
                                           .web(WebApplicationType.NONE)
                                           .run(args) ){
        
        FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
        Function<String,String> reverseFunction = functionCatalog.lookup("reverseFunction");
        // FunctionInvocationWrapper uppercaseFunction = functionCatalog.lookup("uppercase");

        assertThat(reverseFunction.apply("Hello")).isEqualTo("olleH");

            

        }


    }
   

    @Test 
    public void  testUpperCaseAsFluxFunction() {
 
        String [] args = new String [] {
                                 "--spring.cloud.function.location=/home/farhad/apps/my-examples/spring-cloud-function/deploying-packaged-functoion-example/normal-uppercase-function-example/target/normal-uppercase-function-example-0.0.1-SNAPSHOT.jar",
                                 "--spring.cloud.function.function-class=com.farhad.example.function.uppercase.UppercaseFunction;com.farhad.example.function.uppercase.ReverseFunction"
        };
        ApplicationContext context = SpringApplication.run(Application.class, args);
            
        FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
        Function<Flux<String>,Flux<String>> uppercaseFunctionFlux = functionCatalog.lookup("uppercaseFunction");
 
        Flux<String> fluxResult =  uppercaseFunctionFlux.apply(Flux.just("Hello","by"));

        List<String> result =  fluxResult.collectList().block();

        assertThat(result.get(0)).isEqualTo("HELLO");
        assertThat(result.get(1)).isEqualTo("BY");
 
     } 
 
 

}

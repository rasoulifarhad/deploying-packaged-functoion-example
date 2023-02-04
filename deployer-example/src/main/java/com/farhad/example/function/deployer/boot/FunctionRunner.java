package com.farhad.example.function.deployer.boot;

import java.util.function.Function;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

import  org.springframework.cloud.function.context.FunctionCatalog;

// @Configuration
@Slf4j
public class FunctionRunner {

    // @Bean
    public ApplicationRunner uppercaseRunner(FunctionCatalog catalog) {

        return args -> {

            		Function<String,String> uppercaseFunction =  catalog.lookup("uppercaseFunction");

                    String param = "Hello";
                    log.info("{} Uppercased To: {}", param ,uppercaseFunction.apply(param));

        };

    }

    // @Bean
    public ApplicationRunner reverseRunner(FunctionCatalog catalog) {

        return args -> {

            		Function<String,String> reverseFunction =  catalog.lookup("reverseFunction");

                    String param = "Hello";
                    log.info("{} reversed To: {}", param ,reverseFunction.apply(param));

        };

    }
    
}

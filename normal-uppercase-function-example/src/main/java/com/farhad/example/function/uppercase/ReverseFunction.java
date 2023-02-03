package com.farhad.example.function.uppercase;

import java.util.function.Function;
import java.lang.StringBuilder;

public class ReverseFunction implements Function<String,String> {

    @Override
    public String apply(String in) {
        return new StringBuilder(in).reverse().toString();
    }
    
}

package functions;

import java.util.function.Function;

public class UppercaseFunction implements Function<String,String>{

    @Override
    public String apply(String in) {
        return in.toUpperCase();
    }
    
}

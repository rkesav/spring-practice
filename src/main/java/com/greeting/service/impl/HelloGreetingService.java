package com.greeting.service.impl;

import com.greeting.service.GreetingService;
import org.springframework.stereotype.Component;

@Component("helloService")
public class HelloGreetingService implements GreetingService {
    @Override
    public String greet() {
        return "Hello";
    }
}

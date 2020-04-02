package com.greeting.service.impl;

import com.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloService")
public class HelloGreetingService implements GreetingService {

    @Value("{name}")
    private String name;

    @Override
    public String greet() {
        return "Hello" + name;
    }
}

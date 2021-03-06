package com.greeting.service.impl;

import com.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("holaService")
@Primary
public class HolaGreetingService implements GreetingService {

    @Value("${name:world}")
    private String name;

    @Override
    public String greet() {
        return "Hola " + name;
    }
}

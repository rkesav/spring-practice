package com.greeting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    @Autowired
    private GreetingService greetingService;

    String getMessage() {
        return greetingService.greet();
    }
}

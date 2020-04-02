package com.greeting.service;

import com.greeting.config.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.Assert.assertEquals;

@SpringJUnitConfig(classes = Config.class)
@TestPropertySource("classpath:app-test.properties")
public class MessageServicePropertiesTest {

    @Autowired
    MessageService messageService;

    @Test
    void testGetMessage() {
        String message = messageService.getMessage();
        assertEquals("Hola Bharadwaj", message);
    }
}

package com.example.springframework.configuration.service;

import org.springframework.stereotype.Component;

@Component
public class GreetingService implements GreetingServiceInterface {

    public static final String HELLO = "Hello";

    @Override
    public String greet() {
        return HELLO;
    }
}

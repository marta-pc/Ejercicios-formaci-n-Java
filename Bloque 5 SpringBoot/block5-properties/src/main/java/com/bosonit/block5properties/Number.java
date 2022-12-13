package com.bosonit.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Number implements CommandLineRunner {

    @Value("${my.number}")
    private String mynumber;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de my.number es: " + mynumber);
    }
}


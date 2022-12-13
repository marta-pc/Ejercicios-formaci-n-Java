package com.bosonit.block5properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Property implements CommandLineRunner {

    @Value("${new.property}")
    private String newproperty;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("El valor de new.property es: " + newproperty);
    }
}


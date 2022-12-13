package com.bosonit.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador/bean")
public class Controlador {

    @Autowired
    //@Qualifier("bean1")
    private Persona bean1;

    @Autowired
    private Persona bean2;

    @Autowired
    private Persona bean3;

    @GetMapping("/{beanNumber}")
    Object getPersonaByBeanNumber(@PathVariable String beanNumber){
        return switch (beanNumber){
            case "bean1" -> bean1;
            case "bean2" -> bean2;
            case "bean3" -> bean3;
            default -> null;
        };

    }

}
